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
@Slf4j
@Setter
public class ProductManager implements IProductManager {
    IProductValidator validator;
    IRepository repository;


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

            }
            validator.validateAddProductRequest(request);
            Product product = Product.fromGRPC(request.getProduct());
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

    @Override
    public Product getProduct(String productId) {
        return (Product) repository.get(productId);
    }
}
