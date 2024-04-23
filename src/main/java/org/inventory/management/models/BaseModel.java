package org.inventory.management.models;

import lombok.*;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class BaseModel {
    String id;
    long createdOn;
    long modifiedOn;
}
