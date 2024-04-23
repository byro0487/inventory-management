package org.inventory.management.controllers;

import im.BaseServiceOuterClass;
import im.ProductManagementServiceGrpc;
import im.ProductManagementServiceOuterClass;
import io.grpc.stub.StreamObserver;
import lombok.Setter;
import org.inventory.management.services.interfaces.IProductManager;

@Setter
public class ProductManagementImpl extends ProductManagementServiceGrpc.ProductManagementServiceImplBase {
    IProductManager productManager;

    @Override
    public void addProduct(ProductManagementServiceOuterClass.AddProductRequest request, StreamObserver<ProductManagementServiceOuterClass.AddProductResponse> responseObserver) {
        ProductManagementServiceOuterClass.AddProductResponse response = ProductManagementServiceOuterClass.AddProductResponse.getDefaultInstance();
        try{
            response = productManager.addProduct(request);
        }catch (Exception e){
            response= response.toBuilder()
                    .setIsSuccess(false)
                    .setError(BaseServiceOuterClass.Error.newBuilder()
                            .setType(BaseServiceOuterClass.ErrorType.INTERNAL_SERVER_ERROR)
                            .setMessage(e.getMessage()!=null?e.getMessage():"N/A")
                            .build())
                    .build();
        }
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}
