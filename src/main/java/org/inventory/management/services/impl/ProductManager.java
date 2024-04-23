package org.inventory.management.services.impl;

import im.BaseServiceOuterClass;
import im.ProductManagementServiceOuterClass;
import lombok.Setter;
import org.inventory.management.helpers.validators.interfaces.IProductValidator;
import org.inventory.management.models.Product;
import org.inventory.management.repository.interfaces.IRepository;
import org.inventory.management.services.interfaces.IProductManager;

@Setter
public class ProductManager implements IProductManager {
    IProductValidator validator;
    IRepository repository;


    @Override
    public ProductManagementServiceOuterClass.AddProductResponse addProduct(ProductManagementServiceOuterClass.AddProductRequest request) {
        ProductManagementServiceOuterClass.AddProductResponse response= ProductManagementServiceOuterClass.AddProductResponse.getDefaultInstance();
        try{
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
        }
        return response;
    }

    @Override
    public Product getProduct(String productId) {
        return (Product) repository.get(productId);
    }
}
