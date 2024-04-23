package org.inventory.management;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.inventory.management.controllers.AuthServiceImpl;
import org.inventory.management.helpers.H2TableCreator;
import org.inventory.management.helpers.factory.CreateController;
import org.inventory.management.helpers.interceptors.JwtServerInterceptor;

import java.io.IOException;
/**
 * The Main class is responsible for initializing and starting the Inventory Management and Authentication services.
 * It sets up the necessary database tables, starts the gRPC servers for both services, and configures the services
 * with necessary interceptors and service implementations.
 */
public class Main {
    /**
     * Port number on which the Inventory Management server will run.
     */
    private static final int IM_SERVER_PORT = 8080;
    /**
     * Port number on which the Authentication server will run.
     */
    private static final int AUTH_SERVER_PORT = 8081;
    /**
     * The main method that starts the application.
     * It performs the following steps:
     * 1. Creates necessary database tables.
     * 2. Starts the Authentication server in a separate thread.
     * 3. Configures and starts the Inventory Management server with necessary services and interceptors.
     *
     * @param args Command line arguments (not used).
     */
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
    /**
     * Starts the Authentication server in a separate thread.
     * This server listens on a specific port and handles authentication requests.
     */
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