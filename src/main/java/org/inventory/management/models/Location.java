package org.inventory.management.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
public class Location extends BaseModel{
    String houseNumber;
    String streetNumber;
    String city;
    long pinCode;
    String state;
    String country;
}
