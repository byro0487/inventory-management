package org.inventory.management.services.impl;

import im.BaseServiceOuterClass;
import im.ProductManagementServiceOuterClass;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.inventory.management.helpers.ErrorResponses;
import org.inventory.management.helpers.LockManager;
import org.inventory.management.helpers.validators.interfaces.IProductValidator;
import org.inventory.management.models.Product;
import org.inventory.management.repository.interfaces.IRepository;
import org.inventory.management.services.interfaces.IProductManager;
/**
 * Manages product operations including adding products and retrieving product details.
 * This class handles business logic associated with product management and interacts with
 * the product repository and validator.
 */
@Slf4j
@Setter
public class ProductManager implements IProductManager {
    IProductValidator validator;
    IRepository repository;

    /**
     * Adds a product to the repository based on the provided request.
     * This method first acquires a lock based on the product name and description to ensure
     * that no duplicate requests are processed concurrently. It validates the request,
     * converts the GRPC product to a domain model, and adds it to the repository.
     *
     * @param request The product addition request containing product details.
     * @return A response indicating success or failure of the addition operation along with an error message if applicable.
     */
    @Override
    public ProductManagementServiceOuterClass.AddProductResponse addProduct(ProductManagementServiceOuterClass.AddProductRequest request) {
        ProductManagementServiceOuterClass.AddProductResponse response= ProductManagementServiceOuterClass.AddProductResponse.getDefaultInstance();
        String lockKey = request.getProduct().getName()+":"+request.getProduct().getDescription();
        log.info("Started addProduct request with product name: {}",request.getProduct().getName());
        try{
            if(!LockManager.acquireLock(lockKey)){
                response = response.toBuilder()
                        .setIsSuccess(false)
                        .setError(ErrorResponses.duplicateRequest())
                        .build();
                log.error("Error in addProduct request with product name: {} with response: {}",request.getProduct().getName(),response);
                return response;
            }
            validator.validateAddProductRequest(request);
            Product product = Product.fromGRPC(request.getProduct());

            boolean alreadyExists = repository.get(product.getId()) !=null;
            if(alreadyExists){
                response = response.toBuilder()
                        .setIsSuccess(false)
                        .setError(ErrorResponses.alreadyExistsRequest())
                        .build();
                log.error("Error in addProduct request with product name: {} with response: {}",request.getProduct().getId(),response);
                return response;
            }

            product = (Product) repository.add(product);

            response = response.toBuilder()
                    .setIsSuccess(true)
                    .setProductId(product.getId())
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
            log.error("Error in addProduct request with product name: {} with response: {}",request.getProduct().getName(),response);
        }
        finally {
            LockManager.releaseLock(lockKey);
        }
        log.info("Completed addProduct request with product name: {} with response: {}",request.getProduct().getName(),response);
        return response;
    }
    /**
     * Retrieves a product from the repository based on the product ID.
     *
     * @param productId The unique identifier of the product to retrieve.
     * @return The product associated with the given ID or null if no product is found.
     */
    @Override
    public Product getProduct(String productId) {
        return (Product) repository.get(productId);
    }
}
