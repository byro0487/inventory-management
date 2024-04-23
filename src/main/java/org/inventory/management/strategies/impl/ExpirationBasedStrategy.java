package org.inventory.management.strategies.impl;

import org.inventory.management.models.RestockingContext;
import org.inventory.management.strategies.interfaces.IRestockingStrategy;
/**
 * Implements an expiration-based restocking strategy.
 * This strategy calculates the reorder point by considering both the demand during the lead time and the safety stock,
 * while also adjusting for items that are expected to expire before they are used.
 */
public class ExpirationBasedStrategy implements IRestockingStrategy {
    /**
     * Calculates the reorder point for inventory based on the demand, lead time, safety stock, and expected expired items.
     *
     * @param context The restocking context containing necessary data such as demand, lead time, and safety stock.
     * @return The calculated reorder point after adjusting for expired items.
     */
        @Override
        public int calculateReorderPoint(RestockingContext context) {
            // Calculate reorder point based on expiration-based strategy
            int reorderPoint = context.getDemand() * context.getLeadTime() + context.getSafetyStock();

            // Adjust reorder point based on expiration dates
            reorderPoint -= calculateExpiredItems(context);

            return reorderPoint;
        }
    /**
     * Estimates the number of items that will expire during the lead time based on a fixed percentage.
     *
     * @param context The restocking context with details about demand and lead time.
     * @return The number of items expected to expire.
     */
        private int calculateExpiredItems(RestockingContext context) {
            // Simulate calculation of expired items based on expiration dates
            // Example: Assume 10% of items expire during lead time
            int expiredItems = (int) (context.getDemand() * context.getLeadTime() * 0.1);
            System.out.println(expiredItems + " items expired during lead time");
            return expiredItems;
        }
}
