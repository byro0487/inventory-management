package org.inventory.management.strategies.impl;

import org.inventory.management.models.RestockingContext;
import org.inventory.management.strategies.interfaces.IRestockingStrategy;

public class SeasonalDemandStrategy implements IRestockingStrategy {
    @Override
    public int calculateReorderPoint(RestockingContext context) {
        // Adjust reorder point based on seasonal demand
        return context.isSeasonal() ? context.getDemand() * context.getLeadTime() * 2 + context.getSafetyStock() : context.getDemand() * context.getLeadTime() + context.getSafetyStock();
    }
}


