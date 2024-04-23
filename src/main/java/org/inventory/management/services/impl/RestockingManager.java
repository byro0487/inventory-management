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

@Setter
@NoArgsConstructor

@AllArgsConstructor
public class RestockingManager {
    private IRestockingStrategy strategy;
    private IStoreProductManager storeProductManager;


    final int MIN_STOCK = 100;
    final int MAX_STOCK = 1000;

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

    private RestockingContext buildContext(String productId) {
        return RestockingContext.builder()
                .demand(InventoryHistoryService.getProductDemand(productId))
                .leadTime(InventoryHistoryService.getLeadTime(productId))
                .safetyStock(InventoryHistoryService.getSafetyStock(productId))
                .build();
    }

    private IRestockingStrategy getStrategyByProduct(String productId){
        // we can have this specified per product, but currently will be returning JIT strategy
        return new JustInTimeStrategy();
    }



}

