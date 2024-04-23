package org.inventory.management.helpers.factory;

import org.inventory.management.controllers.InventoryManagementImpl;
import org.inventory.management.helpers.validators.impl.InventoryValidator;
import org.inventory.management.helpers.validators.impl.ProductValidator;
import org.inventory.management.helpers.validators.impl.StoreValidator;
import org.inventory.management.helpers.validators.interfaces.IInventoryValidator;
import org.inventory.management.helpers.validators.interfaces.IProductValidator;
import org.inventory.management.helpers.validators.interfaces.IStoreValidator;

public class CreateValidator {

    public static IInventoryValidator createInventoryValidator(){
        return new InventoryValidator();
    }
    public static IProductValidator createProductValidator(){
        return new ProductValidator();
    }
    public static IStoreValidator createStoreValidator(){
        return new StoreValidator();
    }

}
