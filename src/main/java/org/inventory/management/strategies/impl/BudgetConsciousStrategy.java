package org.inventory.management.strategies.impl;

import org.inventory.management.models.RestockingContext;
import org.inventory.management.strategies.interfaces.IRestockingStrategy;
/**
 * A strategy for calculating the reorder point considering the budget constraints.
 * This strategy adjusts the reorder point based on the available budget.
 */
public class BudgetConsciousStrategy implements IRestockingStrategy {
    /**
     * Calculates the reorder point based on the budget.
     * If the budget is less than $1000, the reorder point is calculated as demand times lead time plus safety stock.
     * Otherwise, it is calculated as demand times lead time times two plus safety stock.
     *
     * @param context the restocking context containing demand, lead time, budget, and safety stock information
     * @return the calculated reorder point
     */
    @Override
    public int calculateReorderPoint(RestockingContext context) {
        // Adjust reorder point based on budget
        return context.getBudget() < 1000 ? context.getDemand() * context.getLeadTime() + context.getSafetyStock() : context.getDemand() * context.getLeadTime() * 2 + context.getSafetyStock();
    }
}

