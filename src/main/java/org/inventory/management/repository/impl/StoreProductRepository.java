package org.inventory.management.repository.impl;

import org.inventory.management.models.BaseModel;
import org.inventory.management.models.StoreProduct;
import org.inventory.management.repository.interfaces.IRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StoreProductRepository implements IRepository {

    private static Map<String, StoreProduct> map = new HashMap<>();

    public List<StoreProduct> getAll() {
        return (List<StoreProduct>) map.values();
    }

    @Override
    public BaseModel get(String id) {
        return map.get(id);
    }

    @Override
    public BaseModel add(BaseModel model) {
        StoreProduct storeProduct = (StoreProduct)model;
        String id = createId(storeProduct);
        storeProduct.setId(id);
        map.put(id,storeProduct);
        return storeProduct;
    }

    @Override
    public BaseModel update(BaseModel model) {
        StoreProduct storeProduct = (StoreProduct)model;
        String id = createId(storeProduct);
        map.put(id,storeProduct);
        return storeProduct;
    }

    @Override
    public void remove(String id) {
        map.remove(id);
    }

    private String createId(StoreProduct storeProduct){
        return "StoreProduct:"+storeProduct.getStoreId()+":"+storeProduct.getProductId();
    }

}
