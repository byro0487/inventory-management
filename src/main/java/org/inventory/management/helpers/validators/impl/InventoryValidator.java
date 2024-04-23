package org.inventory.management.helpers.validators.impl;

import im.InventoryManagementServiceOuterClass;
import org.inventory.management.helpers.validators.interfaces.IInventoryValidator;


public class InventoryValidator implements IInventoryValidator {

    @Override
    public void validateAddStoreToInventoryRequest(InventoryManagementServiceOuterClass.AddStoreToInventoryRequest request) {

    }

    @Override
    public void validateViewInventoryRequest(InventoryManagementServiceOuterClass.ViewInventoryRequest viewInventoryRequest) {
        // check for mandatory params, inventoryId, storeId, productId
        // if not throw error
    }
    @Override
    public void validateUpdateInventoryRequest(InventoryManagementServiceOuterClass.UpdateInventoryRequest updateInventoryRequest) {
        // check for mandatory params storeId, productId, operationType, quantity
        // if not throw error
    }
    @Override
    public void validateRestockInventoryRequest(InventoryManagementServiceOuterClass.RestockInventoryRequest restockInventoryRequest) {

    }
}
