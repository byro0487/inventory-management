package org.inventory.management.strategies.impl;

import org.inventory.management.models.RestockingContext;
import org.inventory.management.strategies.interfaces.IRestockingStrategy;

public class ExpirationBasedStrategy implements IRestockingStrategy {
        @Override
        public int calculateReorderPoint(RestockingContext context) {
            // Calculate reorder point based on expiration-based strategy
            int reorderPoint = context.getDemand() * context.getLeadTime() + context.getSafetyStock();

            // Adjust reorder point based on expiration dates
            reorderPoint -= calculateExpiredItems(context);

            return reorderPoint;
        }

        private int calculateExpiredItems(RestockingContext context) {
            // Simulate calculation of expired items based on expiration dates
            // Example: Assume 10% of items expire during lead time
            int expiredItems = (int) (context.getDemand() * context.getLeadTime() * 0.1);
            System.out.println(expiredItems + " items expired during lead time");
            return expiredItems;
        }
}
