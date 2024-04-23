package org.inventory.management.strategies.impl;

import org.inventory.management.models.RestockingContext;
import org.inventory.management.strategies.interfaces.IRestockingStrategy;

public class PeriodicReviewStrategy implements IRestockingStrategy {
    /**
     * Calculates the reorder point for inventory based on a periodic review strategy.
     * This implementation assumes a weekly review period.
     *
     * @param context The RestockingContext containing relevant data such as demand and safety stock.
     * @return int The calculated reorder point, which is the product of weekly demand (demand per day multiplied by 7) added to the safety stock.
     */
    @Override
    public int calculateReorderPoint(RestockingContext context) {
        // Restock periodically, e.g., weekly or monthly
        // For simplicity, let's assume a weekly review
        return context.getDemand() * 7 + context.getSafetyStock();
    }
}
