package org.inventory.management.helpers.factory;

import org.inventory.management.controllers.InventoryManagementImpl;
import org.inventory.management.repository.impl.*;

public class CreateRepository {

    public static InventoryStoreRepository createInventoryStoreRepository(){
        return new InventoryStoreRepository();
    }
    public static LocationRepository createLocationRepository(){
        return new LocationRepository();
    }
    public static ProductRepository createProductRepository(){
        return new ProductRepository();
    }
    public static StoreProductRepository createStoreProductRepository(){
        return new StoreProductRepository();
    }
    public static StoreRepository createStoreRepository(){
        return new StoreRepository();
    }
    public static SupplierRepository createSupplierRepository(){
        return new SupplierRepository();
    }
}
