package org.inventory.management.services.impl;

import lombok.Setter;
import org.inventory.management.models.StoreProduct;
import org.inventory.management.repository.impl.StoreProductRepository;
import org.inventory.management.services.interfaces.IStoreProductManager;

import java.util.List;
@Setter
public class StoreProductManager implements IStoreProductManager {

    StoreProductRepository repository;
    @Override
    public StoreProduct getProduct(String storeId, String productId) {
        return (StoreProduct) repository.get(storeId+":"+productId);
    }

    @Override
    public StoreProduct addProduct(StoreProduct storeProduct) {
        storeProduct = (StoreProduct) repository.add(storeProduct);
        return storeProduct;
    }

    @Override
    public StoreProduct updateProduct(StoreProduct storeProduct) {
        storeProduct = (StoreProduct) repository.update(storeProduct);
        return storeProduct;
    }

    @Override
    public List<StoreProduct> getAll() {
        return  repository.getAll();
    }
}
