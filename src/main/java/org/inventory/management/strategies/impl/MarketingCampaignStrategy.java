package org.inventory.management.strategies.impl;

import org.inventory.management.models.RestockingContext;
import org.inventory.management.strategies.interfaces.IRestockingStrategy;
/**
 * Implements the restocking strategy considering the impact of marketing campaigns on inventory demand.
 * This strategy calculates the reorder point by factoring in the increased safety stock during marketing campaigns.
 */
public class MarketingCampaignStrategy implements IRestockingStrategy {

    /**
     * Calculates the reorder point based on the current demand, lead time, and safety stock.
     * If a marketing campaign is active, the safety stock is doubled to accommodate increased demand.
     *
     * @param context The restocking context containing demand, lead time, safety stock, and marketing campaign status.
     * @return The calculated reorder point.
     */
    @Override
    public int calculateReorderPoint(RestockingContext context) {
        // Increase reorder point during marketing campaigns
        int MARKETING_CAMPAIGN_SAFETY_FACTOR = 2;
        return context.isMarketingCampaigns() ? context.getDemand() * context.getLeadTime() + context.getSafetyStock() * MARKETING_CAMPAIGN_SAFETY_FACTOR : context.getDemand() * context.getLeadTime() + context.getSafetyStock();
    }
}

