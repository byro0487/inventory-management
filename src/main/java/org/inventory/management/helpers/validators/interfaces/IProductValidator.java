package org.inventory.management.helpers.validators.interfaces;

import im.ProductManagementServiceOuterClass;

public interface IProductValidator {
    void validateAddProductRequest(ProductManagementServiceOuterClass.AddProductRequest productRequest);
}
