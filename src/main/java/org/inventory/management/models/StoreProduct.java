package org.inventory.management.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.inventory.management.constants.ProductCategory;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
public class StoreProduct extends BaseModel{
    String storeId;
    String productId;
    int quantity;
}
