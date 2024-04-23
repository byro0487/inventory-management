package org.inventory.management.strategies.interfaces;

import org.inventory.management.models.RestockingContext;

// Define a restocking strategy interface
public interface IRestockingStrategy {
    int calculateReorderPoint(RestockingContext context);
}

