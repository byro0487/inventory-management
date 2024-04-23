package org.inventory.management.services.impl;

import im.BaseServiceOuterClass;
import im.InventoryManagementServiceOuterClass;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.inventory.management.helpers.ErrorResponses;
import org.inventory.management.helpers.LockManager;
import org.inventory.management.helpers.validators.interfaces.IInventoryValidator;
import org.inventory.management.models.Product;
import org.inventory.management.models.StoreProduct;
import org.inventory.management.services.interfaces.IInventoryManager;
import org.inventory.management.services.interfaces.IProductManager;
import org.inventory.management.services.interfaces.IStoreProductManager;
@Slf4j
@Setter
public class InventoryManager implements IInventoryManager {

    RestockingManager restockingManager;
    IInventoryValidator validator;
    IProductManager productManager;
    IStoreProductManager storeProductManager;

    /**
     * Retrieves the inventory details for a specific product in a specified store.
     * This method checks product existence and then fetches its inventory details.
     *
     * @param request The inventory view request containing identifiers for the store and the product.
     * @return A response object that indicates the success or failure of the operation.
     *         If successful, it includes product details and the available quantity.
     */
    @Override
    public InventoryManagementServiceOuterClass.ViewInventoryResponse viewInventory(InventoryManagementServiceOuterClass.ViewInventoryRequest request) {
        InventoryManagementServiceOuterClass.ViewInventoryResponse response= InventoryManagementServiceOuterClass.ViewInventoryResponse.getDefaultInstance();
        log.info("Started viewInventory request with storeId: {}",request.getStoreId());
        try{
            validator.validateViewInventoryRequest(request);

            String storeId = request.getStoreId();
            String productId = request.getProductId();
            Product product = productManager.getProduct(productId);
            if(product==null){
                response = response.toBuilder()
                        .setIsSuccess(false)
                        .setError(ErrorResponses.noProductWithGivenId())
                        .build();
                log.error("Error in viewInventory request with storeId: {} with response: {}",request.getStoreId(),response);
                return response;
            }

            StoreProduct storeProduct = storeProductManager.getProduct(storeId,productId);
            if(storeProduct==null ){
                response = response.toBuilder()
                        .setIsSuccess(false)
                        .setError(ErrorResponses.noProductInTheStore())
                        .build();
                log.error("Error in viewInventory request with storeId: {} with response: {}",request.getStoreId(),response);
                return response;
            }

            response = response.toBuilder()
                    .setIsSuccess(true)
                    .setProduct(product.toGrpc())
                    .setQuantityAvailable(storeProduct.getQuantity())
                    .build();
        }
        catch (Exception e){
            response = response.toBuilder()
                    .setIsSuccess(false)
                    .setError(BaseServiceOuterClass.Error.newBuilder()
                            .setMessage(e.getMessage())
                            .setType(BaseServiceOuterClass.ErrorType.INTERNAL_SERVER_ERROR)
                            .build())
                    .build();
            log.error("Error in viewInventory request with storeId: {} with response: {}",request.getStoreId(),response);
        }
        log.info("Completed viewInventory request with storeId: {} with response: {}",request.getStoreId(),response);
        return response;
    }

    /**
     * Updates the inventory quantity for a specific product in a store based on the provided operation type (ADD or SUBTRACT).
     * This method handles locking to ensure that inventory updates are thread-safe and consistent.
     *
     * @param request The inventory update request containing store and product identifiers, operation type, and the quantity to update.
     * @return A response object indicating success or failure of the update operation, and the updated quantity if successful.
     */
    @Override
    public InventoryManagementServiceOuterClass.UpdateInventoryResponse updateInventory(InventoryManagementServiceOuterClass.UpdateInventoryRequest request) {
        InventoryManagementServiceOuterClass.UpdateInventoryResponse response= InventoryManagementServiceOuterClass.UpdateInventoryResponse.getDefaultInstance();
        String lockKey = request.getStoreId()+":"+request.getProductId();
        log.info("Started updateInventory request with storeId: {}",request.getStoreId());
        try{
            if(!LockManager.acquireLock(lockKey)){
                response = response.toBuilder()
                        .setIsSuccess(false)
                        .setError(ErrorResponses.duplicateRequest())
                        .build();
                log.error("Error in updateInventory request with storeId: {} with response: {}",request.getStoreId(),response);
            }
            validator.validateUpdateInventoryRequest(request);
            String storeId = request.getStoreId();
            String productId = request.getProductId();
            Product product = productManager.getProduct(productId);
            if(product==null){
                response = response.toBuilder()
                        .setIsSuccess(false)
                        .setError(ErrorResponses.noProductWithGivenId())
                        .build();
                log.error("Error in updateInventory request with storeId: {} with response: {}",request.getStoreId(),response);
                return response;
            }

            StoreProduct storeProduct = storeProductManager.getProduct(storeId, productId);
            if(BaseServiceOuterClass.OperationType.ADD == request.getType()){
                storeProduct = updateStateProductForADD(request, storeProduct, storeId, productId);

            }else{
                if(storeProduct==null ){
                    response = response.toBuilder()
                            .setIsSuccess(false)
                            .setError(ErrorResponses.noProductInTheStore())
                            .build();
                    log.error("Error in updateInventory request with storeId: {} with response: {}",request.getStoreId(),response);
                    return response;
                }

                int currQuantity = storeProduct.getQuantity();

                if(currQuantity<request.getQuantity()){
                    response = response.toBuilder()
                            .setIsSuccess(false)
                            .setError(BaseServiceOuterClass.Error.newBuilder()
                                    .setMessage("Current Product quantity is less than the amount requested. ")
                                    .setType(BaseServiceOuterClass.ErrorType.BAD_REQUEST)
                                    .build())
                            .build();
                    log.error("Error in updateInventory request with storeId: {} with response: {}",request.getStoreId(),response);
                    return response;
                }
                storeProduct.setQuantity(storeProduct.getQuantity()-request.getQuantity());
                storeProduct = storeProductManager.updateProduct(storeProduct);
            }

            response = response.toBuilder()
                    .setIsSuccess(true)
                    .setStoreId(storeId)
                    .setProductId(productId)
                    .setUpdatedQuantity(storeProduct.getQuantity())
                    .build();
        }
        catch (Exception e){
            response = response.toBuilder()
                    .setIsSuccess(false)
                    .setError(BaseServiceOuterClass.Error.newBuilder()
                            .setMessage(e.getMessage())
                            .setType(BaseServiceOuterClass.ErrorType.INTERNAL_SERVER_ERROR)
                            .build())
                    .build();
            log.error("Error in updateInventory request with storeId: {} with response: {}",request.getStoreId(),response);
        }finally {
            LockManager.releaseLock(lockKey);
        }
        log.info("Completed updateInventory request with storeId: {} with response: {}",request.getStoreId(),response);
        return response;
    }

    /**
     * Initiates a restocking process for inventory based on predefined restocking strategies.
     * This method also handles locking to prevent concurrent restocking processes.
     *
     * @param request The restock inventory request containing a unique request identifier.
     * @return A response object indicating the success or failure of the restocking process.
     */
    @Override
    public InventoryManagementServiceOuterClass.RestockInventoryResponse restockInventory(InventoryManagementServiceOuterClass.RestockInventoryRequest request) {
        InventoryManagementServiceOuterClass.RestockInventoryResponse response= InventoryManagementServiceOuterClass.RestockInventoryResponse.getDefaultInstance();
        String lockKey = "RESTOCK_INVENTORY";
        log.info("Started restockInventory request with requestId: {}",request.getRequestId());
        try{
            if(!LockManager.acquireLock(lockKey)){
                response = response.toBuilder()
                        .setIsSuccess(false)
                        .setError(ErrorResponses.duplicateRequest())
                        .build();
                log.error("Error in restockInventory request with requestId: {} with response: {}",request.getRequestId(),response);
            }
            restockingManager.restockInventory();
            response = response.toBuilder()
                    .setIsSuccess(true)
                    .build();
        }
        catch (Exception e){
            response = response.toBuilder()
                    .setIsSuccess(false)
                    .setError(BaseServiceOuterClass.Error.newBuilder()
                            .setMessage(e.getMessage())
                            .setType(BaseServiceOuterClass.ErrorType.INTERNAL_SERVER_ERROR)
                            .build())
                    .build();
            log.error("Error in restockInventory request with requestId: {} with response: {}",request.getRequestId(),response);
        }
        finally {
            LockManager.releaseLock(lockKey);
        }
        log.info("Completed restockInventory request with requestId: {} with response: {}",request.getRequestId(),response);
        return response;
    }

    /**
     * Determines the appropriate {@link StoreProduct} instance based on the operation type specified in the request.
     * If the operation type is ADD and the product does not exist in the store, a new StoreProduct instance is created.
     *
     * @param request The inventory update request containing the operation type.
     * @param storeId The identifier of the store.
     * @param productId The identifier of the product.
     * @return The {@link StoreProduct} instance, either retrieved or newly created.
     */
    private StoreProduct getStoreProductByOpType(InventoryManagementServiceOuterClass.UpdateInventoryRequest request, String storeId, String productId) {
        StoreProduct storeProduct = storeProductManager.getProduct(storeId, productId);
        if(BaseServiceOuterClass.OperationType.ADD == request.getType() && storeProduct==null ) {
            storeProduct = StoreProduct.builder()
                    .storeId(storeId)
                    .productId(productId)
                    .build();
            storeProduct.setId(storeId+":"+productId);
        }
        return storeProduct;
    }

    /**
     * Updates or creates a {@link StoreProduct} instance for adding inventory.
     * If the {@link StoreProduct} does not exist for the specified store and product IDs,
     * a new instance is created with the initial quantity set to the quantity specified in the request.
     * If the {@link StoreProduct} exists, the specified quantity is added to the existing quantity.
     *
     * @param request The inventory update request containing the operation type, store ID, product ID, and quantity.
     * @param storeProduct The current {@link StoreProduct} instance, or null if it does not exist.
     * @param storeId The identifier of the store.
     * @param productId The identifier of the product.
     * @return The updated or newly created {@link StoreProduct} instance.
     */
    private StoreProduct updateStateProductForADD(InventoryManagementServiceOuterClass.UpdateInventoryRequest request, StoreProduct storeProduct, String storeId, String productId) {
        if(storeProduct ==null ) {
            storeProduct = StoreProduct.builder()
                    .storeId(storeId)
                    .productId(productId)
                    .quantity(request.getQuantity())
                    .build();
            storeProduct.setId(storeId +":"+ productId);
            storeProduct = storeProductManager.addProduct(storeProduct);
        }else{
            storeProduct.setQuantity(storeProduct.getQuantity()+ request.getQuantity());
            storeProduct = storeProductManager.updateProduct(storeProduct);
        }
        return storeProduct;
    }
}
