package org.inventory.management.helpers.validators.impl;

import im.ProductManagementServiceOuterClass;
import org.inventory.management.helpers.validators.interfaces.IProductValidator;


public class ProductValidator implements IProductValidator {
    @Override
    public void validateAddProductRequest(ProductManagementServiceOuterClass.AddProductRequest productRequest) {
        // check if name,supplierId and unitPrice are not missing as they are mandatory
        // if not send bad request error
    }
}
