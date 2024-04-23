package org.inventory.management.models;

import im.StoreManagementServiceOuterClass;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.inventory.management.constants.EntityStatus;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
public class Store extends BaseModel{
    String name;
    double area;
    EntityStatus status;
    String locationId;
    String managerId;
    String inventoryId;

    public static Store fromGRPC(StoreManagementServiceOuterClass.Store store){
        return Store.builder()
                .name(store.getName())
                .area(store.getArea())
                .status(EntityStatus.valueOf(store.getStatus().toString()))
                .locationId(store.getLocationId())
                .managerId(store.getManagerId())
                .build();
    }
}
