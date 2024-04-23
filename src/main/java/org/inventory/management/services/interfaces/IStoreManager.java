package org.inventory.management.services.interfaces;

import im.StoreManagementServiceOuterClass;
import org.inventory.management.models.Product;
import org.inventory.management.models.Store;


public interface IStoreManager {
    StoreManagementServiceOuterClass.AddStoreResponse addStore(StoreManagementServiceOuterClass.AddStoreRequest request);
    Store getStore(String storeId);

}
