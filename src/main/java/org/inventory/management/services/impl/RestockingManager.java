package org.inventory.management.services.impl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.inventory.management.external.InventoryHistoryService;
import org.inventory.management.models.RestockingContext;
import org.inventory.management.models.StoreProduct;
import org.inventory.management.services.interfaces.IStoreProductManager;
import org.inventory.management.strategies.impl.JustInTimeStrategy;
import org.inventory.management.strategies.interfaces.IRestockingStrategy;

import java.util.ArrayList;
import java.util.List;
/**
 * Manages the restocking process for products in inventory.
 * This class is responsible for calculating the necessary quantity to reorder for each product
 * based on the current inventory levels, demand, and lead times.
 */
@Setter
@NoArgsConstructor

@AllArgsConstructor
public class RestockingManager {
    private IRestockingStrategy strategy;
    private IStoreProductManager storeProductManager;


    final int MIN_STOCK = 100;
    final int MAX_STOCK = 1000;
    /**
     * Initiates the restocking process for all products in the inventory.
     * It calculates the reorder point for each product and updates the inventory accordingly.
     */
    public void restockInventory(){
        // iterate over all entries in the store-product table which gives us each store-product combo
        List<StoreProduct> storeProducts = storeProductManager.getAll();

        for (StoreProduct storeProduct : storeProducts) {
            int currQuantity = storeProduct.getQuantity();
            String productId = storeProduct.getProductId();

            RestockingContext context = buildContext(productId);
            strategy = getStrategyByProduct(productId);
            int reOrderCount = strategy.calculateReorderPoint(context);
            int updatedQuantity = currQuantity+reOrderCount;
            updatedQuantity = Math.max(MAX_STOCK,updatedQuantity);
            storeProduct.setQuantity(updatedQuantity);
            storeProductManager.updateProduct(storeProduct);
        }
    }
    /**
     * Builds the restocking context for a given product ID.
     * This includes fetching the demand, lead time, and safety stock for the product.
     *
     * @param productId the ID of the product for which to build the context
     * @return the built RestockingContext
     */
    private RestockingContext buildContext(String productId) {
        return RestockingContext.builder()
                .demand(InventoryHistoryService.getProductDemand(productId))
                .leadTime(InventoryHistoryService.getLeadTime(productId))
                .safetyStock(InventoryHistoryService.getSafetyStock(productId))
                .build();
    }
    /**
     * Determines the appropriate restocking strategy for a given product.
     * Currently defaults to the Just In Time (JIT) strategy.
     *
     * @param productId the ID of the product for which to determine the strategy
     * @return the restocking strategy
     */
    private IRestockingStrategy getStrategyByProduct(String productId){
        // we can have this specified per product, but currently will be returning JIT strategy
        return new JustInTimeStrategy();
    }

}

