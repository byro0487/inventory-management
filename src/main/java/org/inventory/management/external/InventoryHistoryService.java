package org.inventory.management.external;

public class InventoryHistoryService {

    private static final int DEFAULT_DEMAND_PER_DAY = 100;
    private static final int DEFAULT_SAFETY_STOCK = 700;

    private static final int DEFAULT_LEAD_TIME = 0;

    public static int getProductDemand(String productId){
        // This will ideally make a call to our analytics service which calculates and stores th demand for each service.

        // currently returning default value
        return DEFAULT_DEMAND_PER_DAY;
    }

    public static int getSafetyStock(String productId){
        // This will ideally make a call to our analytics service which calculates and stores th demand for each service.

        // currently returning default value
        return DEFAULT_SAFETY_STOCK;
    }

    public static int getLeadTime(String productId){
        // This will ideally make a call to our analytics service which calculates and stores th demand for each service.

        // currently returning default value as 0, as given in the requirements doc
        return DEFAULT_LEAD_TIME;
    }

}
