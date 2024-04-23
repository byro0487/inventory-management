package org.inventory.management.strategies.impl;

import org.inventory.management.models.RestockingContext;
import org.inventory.management.strategies.interfaces.IRestockingStrategy;
/**
 * Implements a restocking strategy that adjusts reorder points based on seasonal variations in demand.
 */
public class SeasonalDemandStrategy implements IRestockingStrategy {
    /**
     * Calculates the reorder point considering the seasonal impact on demand.
     * If the demand is seasonal, the reorder point is set higher to account for increased demand.
     *
     * @param context The restocking context containing demand, lead time, safety stock, and seasonal flag.
     * @return The calculated reorder point.
     */
    @Override
    public int calculateReorderPoint(RestockingContext context) {
        // Adjust reorder point based on seasonal demand
        return context.isSeasonal() ? context.getDemand() * context.getLeadTime() * 2 + context.getSafetyStock() : context.getDemand() * context.getLeadTime() + context.getSafetyStock();
    }
}


