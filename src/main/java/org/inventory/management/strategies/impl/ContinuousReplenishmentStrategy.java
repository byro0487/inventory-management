package org.inventory.management.strategies.impl;

import org.inventory.management.models.RestockingContext;
import org.inventory.management.strategies.interfaces.IRestockingStrategy;
/**
 * Implements a continuous replenishment strategy for inventory management.
 * This strategy ensures that the inventory is replenished to maintain a constant level of safety stock.
 */
public class ContinuousReplenishmentStrategy implements IRestockingStrategy {
    /**
     * Calculates the reorder point for inventory replenishment.
     * This method returns the safety stock level from the context, ignoring other factors like demand.
     *
     * @param context the restocking context containing inventory details
     * @return the safety stock level as the reorder point
     */
    @Override
    public int calculateReorderPoint(RestockingContext context) {
        // Replenish stock regardless of demand
        return context.getSafetyStock();
    }
}

