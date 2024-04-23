package org.inventory.management.controllers;

import im.BaseServiceOuterClass;
import im.InventoryManagementServiceGrpc;
import im.InventoryManagementServiceOuterClass;
import io.grpc.stub.StreamObserver;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.inventory.management.services.interfaces.IInventoryManager;
import org.inventory.management.services.interfaces.IInventoryStoreManager;

@Setter
public class InventoryManagementImpl extends InventoryManagementServiceGrpc.InventoryManagementServiceImplBase {

    IInventoryStoreManager inventoryStoreManager;
    IInventoryManager inventoryManager;

    @Override
    public void addStoreToInventory(InventoryManagementServiceOuterClass.AddStoreToInventoryRequest request, StreamObserver<InventoryManagementServiceOuterClass.AddStoreToInventoryResponse> responseObserver) {
        InventoryManagementServiceOuterClass.AddStoreToInventoryResponse response = InventoryManagementServiceOuterClass.AddStoreToInventoryResponse.getDefaultInstance();
        try{
            response = inventoryStoreManager.addStoreToInventory(request);
        }catch (Exception e){
            response= response.toBuilder()
                    .setIsSuccess(false)
                    .setError(BaseServiceOuterClass.Error.newBuilder()
                            .setType(BaseServiceOuterClass.ErrorType.INTERNAL_SERVER_ERROR)
                            .setMessage(e.getMessage())
                            .build())
                    .build();
        }
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void updateInventory(InventoryManagementServiceOuterClass.UpdateInventoryRequest request, StreamObserver<InventoryManagementServiceOuterClass.UpdateInventoryResponse> responseObserver) {
        InventoryManagementServiceOuterClass.UpdateInventoryResponse response = InventoryManagementServiceOuterClass.UpdateInventoryResponse.getDefaultInstance();
        try{
            response = inventoryManager.updateInventory(request);
        }catch (Exception e){
            response= response.toBuilder()
                    .setIsSuccess(false)
                    .setError(BaseServiceOuterClass.Error.newBuilder()
                            .setType(BaseServiceOuterClass.ErrorType.INTERNAL_SERVER_ERROR)
                            .setMessage(e.getMessage())
                            .build())
                    .build();
        }
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void viewInventory(InventoryManagementServiceOuterClass.ViewInventoryRequest request, StreamObserver<InventoryManagementServiceOuterClass.ViewInventoryResponse> responseObserver) {
        InventoryManagementServiceOuterClass.ViewInventoryResponse response = InventoryManagementServiceOuterClass.ViewInventoryResponse.getDefaultInstance();
        try{
            response = inventoryManager.viewInventory(request);
        }catch (Exception e){
            response= response.toBuilder()
                    .setIsSuccess(false)
                    .setError(BaseServiceOuterClass.Error.newBuilder()
                            .setType(BaseServiceOuterClass.ErrorType.INTERNAL_SERVER_ERROR)
                            .setMessage(e.getMessage())
                            .build())
                    .build();
        }
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void restockInventory(InventoryManagementServiceOuterClass.RestockInventoryRequest request, StreamObserver<InventoryManagementServiceOuterClass.RestockInventoryResponse> responseObserver) {
        InventoryManagementServiceOuterClass.RestockInventoryResponse response = InventoryManagementServiceOuterClass.RestockInventoryResponse.getDefaultInstance();
        try{
            response = inventoryManager.restockInventory(request);
        }catch (Exception e){
            response= response.toBuilder()
                    .setIsSuccess(false)
                    .setError(BaseServiceOuterClass.Error.newBuilder()
                            .setType(BaseServiceOuterClass.ErrorType.INTERNAL_SERVER_ERROR)
                            .setMessage(e.getMessage())
                            .build())
                    .build();
        }
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
