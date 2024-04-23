package org.inventory.management.helpers.validators.interfaces;


import im.InventoryManagementServiceOuterClass;
import lombok.NonNull;

public interface IInventoryValidator {
    void validateAddStoreToInventoryRequest(@NonNull InventoryManagementServiceOuterClass.AddStoreToInventoryRequest request);
    void validateViewInventoryRequest(@NonNull InventoryManagementServiceOuterClass.ViewInventoryRequest request);
    void validateUpdateInventoryRequest(@NonNull InventoryManagementServiceOuterClass.UpdateInventoryRequest request);
    void validateRestockInventoryRequest(@NonNull InventoryManagementServiceOuterClass.RestockInventoryRequest request);

}
