package org.inventory.management.controllers;

import im.AuthServiceGrpc;
import im.AuthServiceOuterClass;
import im.BaseServiceGrpc;
import im.BaseServiceOuterClass;
import io.grpc.stub.StreamObserver;
import org.inventory.management.external.AuthService;

public class AuthServiceImpl extends AuthServiceGrpc.AuthServiceImplBase {
    @Override
    public void getToken(AuthServiceOuterClass.GetTokenRequest request, StreamObserver<AuthServiceOuterClass.GetTokenResponse> responseObserver) {
        AuthServiceOuterClass.GetTokenResponse response = AuthServiceOuterClass.GetTokenResponse.getDefaultInstance();
        try{
            response= response.toBuilder()
                    .setToken(AuthService.getTokenData(request.getUsername()))
                    .build();
        }catch (Exception e){
            response= response.toBuilder()
                    .build();
        }
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
