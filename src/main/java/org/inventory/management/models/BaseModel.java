package org.inventory.management.models;

import lombok.*;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class BaseModel {
    String id;
    long createdOn;
    long modifiedOn;
}
