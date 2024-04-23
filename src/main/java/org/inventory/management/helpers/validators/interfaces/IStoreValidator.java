package org.inventory.management.helpers.validators.interfaces;

import im.StoreManagementServiceOuterClass;

public interface IStoreValidator {
    void validateAddStoreRequest(StoreManagementServiceOuterClass.AddStoreRequest addStoreRequest);
}
