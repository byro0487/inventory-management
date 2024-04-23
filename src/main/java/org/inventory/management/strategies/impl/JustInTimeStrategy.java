package org.inventory.management.strategies.impl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.inventory.management.models.RestockingContext;
import org.inventory.management.strategies.interfaces.IRestockingStrategy;

@NoArgsConstructor
public class JustInTimeStrategy implements IRestockingStrategy {
    @Override
    public int calculateReorderPoint(RestockingContext context) {
        return context.getDemand() * context.getLeadTime() + context.getSafetyStock();
    }
}

