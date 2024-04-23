package org.inventory.management.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class RestockingContext {
    private int demand;
    private int leadTime;
    private int storageSpace;
    private double budget;
    private boolean seasonal;
    private boolean marketingCampaigns;
    private boolean pricing;
    private boolean returnPolicy;
    private boolean perishable;
    private int safetyStock;
}
