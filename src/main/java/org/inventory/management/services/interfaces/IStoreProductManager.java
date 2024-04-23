package org.inventory.management.services.interfaces;

import org.inventory.management.models.StoreProduct;

import java.util.List;

public interface IStoreProductManager {
    StoreProduct getProduct(String storeId ,String productId);
    StoreProduct addProduct(StoreProduct storeProduct);

    StoreProduct updateProduct(StoreProduct storeProduct);

    List<StoreProduct> getAll();
}
