package org.inventory.management.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.inventory.management.constants.EntityStatus;
import org.inventory.management.constants.SupplierType;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
public class Supplier extends BaseModel{
    String name;
    String description;
    long registeredOn;
    EntityStatus status;
    SupplierType type;
    String locationId;
}
