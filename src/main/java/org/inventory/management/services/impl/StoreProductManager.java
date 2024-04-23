package org.inventory.management.services.impl;

import lombok.Setter;
import org.inventory.management.models.StoreProduct;
import org.inventory.management.repository.impl.StoreProductRepository;
import org.inventory.management.services.interfaces.IStoreProductManager;

import java.util.List;
/**
 * Manages operations for store products.
 * This class provides methods to add, update, retrieve, and list all store products.
 */
@Setter
public class StoreProductManager implements IStoreProductManager {

    StoreProductRepository repository;
    /**
     * Retrieves a product using a combined key of store ID and product ID.
     *
     * @param storeId The ID of the store.
     * @param productId The ID of the product.
     * @return The store product if found, otherwise null.
     */
    @Override
    public StoreProduct getProduct(String storeId, String productId) {
        return (StoreProduct) repository.get(storeId+":"+productId);
    }
    /**
     * Adds a new store product to the repository.
     *
     * @param storeProduct The store product to add.
     * @return The added store product.
     */
    @Override
    public StoreProduct addProduct(StoreProduct storeProduct) {
        storeProduct = (StoreProduct) repository.add(storeProduct);
        return storeProduct;
    }
    /**
     * Updates an existing store product in the repository.
     *
     * @param storeProduct The store product to update.
     * @return The updated store product.
     */
    @Override
    public StoreProduct updateProduct(StoreProduct storeProduct) {
        storeProduct = (StoreProduct) repository.update(storeProduct);
        return storeProduct;
    }
    /**
     * Retrieves all store products from the repository.
     *
     * @return A list of all store products.
     */
    @Override
    public List<StoreProduct> getAll() {
        return  repository.getAll();
    }
}
