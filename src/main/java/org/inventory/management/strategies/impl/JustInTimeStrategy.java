package org.inventory.management.strategies.impl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.inventory.management.models.RestockingContext;
import org.inventory.management.strategies.interfaces.IRestockingStrategy;
/**
 * Implements the {@link IRestockingStrategy} for a just-in-time inventory strategy.
 * This strategy calculates the reorder point based on demand, lead time, and safety stock.
 */
@NoArgsConstructor
public class JustInTimeStrategy implements IRestockingStrategy {
    /**
     * Calculates the reorder point for inventory based on the provided {@link RestockingContext}.
     * The reorder point is determined by the formula: (demand * lead time) + safety stock.
     *
     * @param context the {@link RestockingContext} containing inventory parameters
     * @return the calculated reorder point as an integer
     */
    @Override
    public int calculateReorderPoint(RestockingContext context) {
        return context.getDemand() * context.getLeadTime() + context.getSafetyStock();
    }
}

