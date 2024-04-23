package org.inventory.management.helpers.factory;

import org.inventory.management.controllers.InventoryManagementImpl;
import org.inventory.management.services.impl.*;
import org.inventory.management.services.interfaces.IInventoryStoreManager;

public class CreateManager {

    public static IInventoryStoreManager createInventoryStoreManager(){
        InventoryStoreManager inventoryStoreManager = new InventoryStoreManager();
        inventoryStoreManager.setValidator(CreateValidator.createInventoryValidator());
        inventoryStoreManager.setStoreManager(createStoreManager());
        inventoryStoreManager.setRepository(CreateRepository.createInventoryStoreRepository());
        return inventoryStoreManager;
    }

    public static InventoryManager createInventoryManager(){
        InventoryManager inventoryManager = new InventoryManager();
        inventoryManager.setRestockingManager(createRestockingManager());
        inventoryManager.setValidator(CreateValidator.createInventoryValidator());
        inventoryManager.setProductManager(createProductManager());
        inventoryManager.setStoreProductManager(createStoreProductManager());
        return inventoryManager;
    }

    public static RestockingManager createRestockingManager(){
        RestockingManager restockingManager = new RestockingManager();
        restockingManager.setStoreProductManager(createStoreProductManager());
        restockingManager.setStrategy(CreateStrategy.createBaseStrategy());
        return restockingManager;
    }

    public static StoreManager createStoreManager(){
        StoreManager storeManager = new StoreManager();
        storeManager.setValidator(CreateValidator.createStoreValidator());
        storeManager.setRepository(CreateRepository.createStoreRepository());
        return storeManager;
    }

    public static StoreProductManager createStoreProductManager(){
        StoreProductManager storeProductManager = new StoreProductManager();
        storeProductManager.setRepository(CreateRepository.createStoreProductRepository());
        return storeProductManager;
    }
    public static ProductManager createProductManager(){
        ProductManager productManager = new ProductManager();
        productManager.setValidator(CreateValidator.createProductValidator());
        productManager.setRepository(CreateRepository.createProductRepository());
        return productManager;
    }
}
