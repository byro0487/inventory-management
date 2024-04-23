package org.inventory.management.helpers.factory;

import org.inventory.management.controllers.InventoryManagementImpl;
import org.inventory.management.controllers.ProductManagementImpl;
import org.inventory.management.controllers.StoreManagementImpl;

public class CreateController {

    public static InventoryManagementImpl createInventoryManagementImpl(){
        InventoryManagementImpl inventoryManagement = new InventoryManagementImpl();
        inventoryManagement.setInventoryManager(CreateManager.createInventoryManager());
        inventoryManagement.setInventoryStoreManager(CreateManager.createInventoryStoreManager());
        return inventoryManagement;
    }

    public static StoreManagementImpl createStoreManagementImpl(){
        StoreManagementImpl storeManagement = new StoreManagementImpl();
        storeManagement.setStoreManager(CreateManager.createStoreManager());
        return storeManagement;
    }

    public static ProductManagementImpl createProductManagementImpl(){
        ProductManagementImpl productManagement = new ProductManagementImpl();
        productManagement.setProductManager(CreateManager.createProductManager());
        return productManagement;
    }
}
