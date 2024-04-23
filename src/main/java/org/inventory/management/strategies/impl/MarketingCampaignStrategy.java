package org.inventory.management.strategies.impl;

import org.inventory.management.models.RestockingContext;
import org.inventory.management.strategies.interfaces.IRestockingStrategy;

public class MarketingCampaignStrategy implements IRestockingStrategy {

    @Override
    public int calculateReorderPoint(RestockingContext context) {
        // Increase reorder point during marketing campaigns
        int MARKETING_CAMPAIGN_SAFETY_FACTOR = 2;
        return context.isMarketingCampaigns() ? context.getDemand() * context.getLeadTime() + context.getSafetyStock() * MARKETING_CAMPAIGN_SAFETY_FACTOR : context.getDemand() * context.getLeadTime() + context.getSafetyStock();
    }
}

