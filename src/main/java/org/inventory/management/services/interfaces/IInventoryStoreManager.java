package org.inventory.management.services.interfaces;

import im.InventoryManagementServiceOuterClass;
import org.inventory.management.models.StoreProduct;

public interface IInventoryStoreManager {
    InventoryManagementServiceOuterClass.AddStoreToInventoryResponse addStoreToInventory(InventoryManagementServiceOuterClass.AddStoreToInventoryRequest request);
}
