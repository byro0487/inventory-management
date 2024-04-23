package org.inventory.management.models;

import im.BaseServiceOuterClass;
import im.StoreManagementServiceOuterClass;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.inventory.management.constants.EntityStatus;
import org.inventory.management.constants.ProductCategory;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
public class Product extends BaseModel{
    String name;
    String description;
    ProductCategory category;
    double unitPrice;
    String supplierId;

    public BaseServiceOuterClass.Product toGrpc(){
        return BaseServiceOuterClass.Product.newBuilder()
                .setId(this.getId())
                .setName(this.getName())
                .setDescription(this.getDescription())
                .setCategory(BaseServiceOuterClass.ProductCategory.valueOf(category.toString()))
                .setUnitPrice(this.getUnitPrice())
                .setSupplierId(this.getSupplierId())
                .build();
    }

    public static Product fromGRPC(BaseServiceOuterClass.Product product){
        return Product.builder()
                .name(product.getName())
                .description(product.getDescription())
                .category(ProductCategory.valueOf(product.getCategory().toString()))
                .unitPrice(product.getUnitPrice())
                .supplierId(product.getSupplierId())
                .build();
    }

}
