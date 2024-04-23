package org.inventory.management.services.interfaces;

import im.ProductManagementServiceOuterClass;
import org.inventory.management.models.Product;

public interface IProductManager {
    ProductManagementServiceOuterClass.AddProductResponse addProduct(ProductManagementServiceOuterClass.AddProductRequest request);
    Product getProduct(String productId);
}
