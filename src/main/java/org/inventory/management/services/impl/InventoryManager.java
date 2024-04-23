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

            StoreProduct storeProduct = getStoreProductByOpType(request,storeId,productId);
            if(BaseServiceOuterClass.OperationType.ADD == request.getType()){
                storeProduct.setQuantity(storeProduct.getQuantity()+request.getQuantity());
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
            }

            storeProduct = storeProductManager.updateProduct(storeProduct);

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

    private StoreProduct getStoreProductByOpType(InventoryManagementServiceOuterClass.UpdateInventoryRequest request, String storeId, String productId) {
        StoreProduct storeProduct = storeProductManager.getProduct(storeId, productId);
        if(BaseServiceOuterClass.OperationType.ADD == request.getType() && storeProduct==null ) {
            storeProduct = StoreProduct.builder()
                    .storeId(storeId)
                    .productId(productId)
                    .build();
        }
        return storeProduct;
    }
}
