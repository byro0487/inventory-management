package org.inventory.management.strategies.impl;

import org.inventory.management.models.RestockingContext;
import org.inventory.management.strategies.interfaces.IRestockingStrategy;

public class PeriodicReviewStrategy implements IRestockingStrategy {
    @Override
    public int calculateReorderPoint(RestockingContext context) {
        // Restock periodically, e.g., weekly or monthly
        // For simplicity, let's assume a weekly review
        return context.getDemand() * 7 + context.getSafetyStock();
    }
}
