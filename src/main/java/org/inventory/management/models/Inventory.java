package org.inventory.management.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
public class Inventory extends BaseModel{
    String name;
    Map<String, List<String>> storeIdToProducts;
    Map<String,Integer> productIdToQuantity;
}
