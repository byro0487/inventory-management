package org.inventory.management.strategies.impl;

import org.inventory.management.models.RestockingContext;
import org.inventory.management.strategies.interfaces.IRestockingStrategy;

public class ContinuousReplenishmentStrategy implements IRestockingStrategy {
    @Override
    public int calculateReorderPoint(RestockingContext context) {
        // Replenish stock regardless of demand
        return context.getSafetyStock();
    }
}

