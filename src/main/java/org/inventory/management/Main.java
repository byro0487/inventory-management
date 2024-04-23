package org.inventory.management;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.inventory.management.helpers.factory.CreateController;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {

            Server server = ServerBuilder.forPort(8080)
                    .addService(CreateController.createInventoryManagementImpl())
                    .addService( CreateController.createStoreManagementImpl())
                    .addService( CreateController.createProductManagementImpl())
                    .build();

            server.start();
            System.out.println("Inventory Management Service started at " + server.getPort());
            server.awaitTermination();

            // use this for authehttps://github.com/grpc/grpc-java/blob/master/examples/example-jwt-auth/src/main/java/io/grpc/examples/jwtauth/JwtServerInterceptor.java
            // https://dev.to/techschoolguru/use-grpc-interceptor-for-authorization-with-jwt-1c5h

        } catch (IOException | InterruptedException e) {
            System.out.println("Error: " + e);
        }
    }

}