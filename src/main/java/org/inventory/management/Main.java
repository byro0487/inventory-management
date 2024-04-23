package org.inventory.management;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.inventory.management.controllers.AuthServiceImpl;
import org.inventory.management.helpers.H2TableCreator;
import org.inventory.management.helpers.factory.CreateController;
import org.inventory.management.helpers.interceptors.JwtServerInterceptor;

import java.io.IOException;

public class Main {
    private static final int IM_SERVER_PORT = 8080;
    private static final int AUTH_SERVER_PORT = 8081;
    public static void main(String[] args) {
        try {
            H2TableCreator.createTables();
            startAuthServer();
            Server server = ServerBuilder.forPort(IM_SERVER_PORT)
                    .addService(CreateController.createInventoryManagementImpl())
                    .addService( CreateController.createStoreManagementImpl())
                    .addService( CreateController.createProductManagementImpl())
                    .intercept(new JwtServerInterceptor())
                    .build();

            server.start();
            System.out.println("Inventory Management Service started at " + server.getPort());
            server.awaitTermination();

        } catch (IOException | InterruptedException e) {
            System.out.println("Error: " + e);
        }
    }

    private static void startAuthServer() {

        new Thread(()->{
            try {
                Server server = ServerBuilder.forPort(AUTH_SERVER_PORT)
                        .addService(new AuthServiceImpl())
                        .build();

                server.start();
                System.out.println("Auth Service started at " + server.getPort());
                server.awaitTermination();
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}