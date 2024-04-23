package org.inventory.management.repository.impl;

import org.inventory.management.models.BaseModel;
import org.inventory.management.models.InventoryStore;
import org.inventory.management.models.Product;
import org.inventory.management.repository.interfaces.IRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class ProductRepository implements IRepository {
    private static Map<String, Product> map = new HashMap<>();
    @Override
    public BaseModel get(String id) {
        return map.get(id);
    }

    @Override
    public BaseModel add(BaseModel model) {
        Product product = (Product)model;
        String id = "Product:"+map.size();
        product.setId(id);
        map.put(id,product);
        return product;
    }

    @Override
    public BaseModel update(BaseModel model) {
        Product product = (Product)model;
        String id = "Product:"+map.size();
        map.put(id,product);
        return product;
    }

    @Override
    public void remove(String id) {
        map.remove(id);
    }
}
