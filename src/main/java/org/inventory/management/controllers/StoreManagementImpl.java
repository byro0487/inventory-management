package org.inventory.management.controllers;

import im.BaseServiceOuterClass;
import im.StoreManagementServiceGrpc;
import im.StoreManagementServiceOuterClass;
import io.grpc.stub.StreamObserver;
import lombok.Setter;
import org.inventory.management.services.interfaces.IStoreManager;


@Setter
public class StoreManagementImpl extends StoreManagementServiceGrpc.StoreManagementServiceImplBase {
    IStoreManager storeManager;

    @Override
    public void addStore(StoreManagementServiceOuterClass.AddStoreRequest request, StreamObserver<StoreManagementServiceOuterClass.AddStoreResponse> responseObserver) {
        StoreManagementServiceOuterClass.AddStoreResponse response = StoreManagementServiceOuterClass.AddStoreResponse.getDefaultInstance();
        try{
            response = storeManager.addStore(request);
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
