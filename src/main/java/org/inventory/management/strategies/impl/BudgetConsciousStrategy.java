package org.inventory.management.strategies.impl;

import org.inventory.management.models.RestockingContext;
import org.inventory.management.strategies.interfaces.IRestockingStrategy;

public class BudgetConsciousStrategy implements IRestockingStrategy {
    @Override
    public int calculateReorderPoint(RestockingContext context) {
        // Adjust reorder point based on budget
        return context.getBudget() < 1000 ? context.getDemand() * context.getLeadTime() + context.getSafetyStock() : context.getDemand() * context.getLeadTime() * 2 + context.getSafetyStock();
    }
}

