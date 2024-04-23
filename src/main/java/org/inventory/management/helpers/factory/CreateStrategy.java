package org.inventory.management.helpers.factory;

import org.inventory.management.strategies.impl.JustInTimeStrategy;
import org.inventory.management.strategies.interfaces.IRestockingStrategy;

public class CreateStrategy {

    public static IRestockingStrategy createBaseStrategy(){
        return new JustInTimeStrategy();
    }

}
