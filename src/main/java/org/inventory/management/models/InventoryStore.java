package org.inventory.management.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
public class InventoryStore extends BaseModel{
    String inventoryId;
    String storeId;
    String managerId;
}
