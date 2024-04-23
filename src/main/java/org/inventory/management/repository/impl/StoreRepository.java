package org.inventory.management.repository.impl;

import org.inventory.management.models.BaseModel;
import org.inventory.management.models.Store;
import org.inventory.management.repository.interfaces.IRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class StoreRepository implements IRepository {
    private static Map<String, Store> map = new HashMap<>();
    @Override
    public BaseModel get(String id) {
        return map.get(id);
    }

    @Override
    public BaseModel add(BaseModel model) {
        Store store = (Store)model;
        String id = "Store:"+map.size();
        store.setId(id);
        map.put(id,store);
        return store;
    }

    @Override
    public BaseModel update(BaseModel model) {
        Store store = (Store)model;
        String id = "Store:"+map.size();
        map.put(id,store);
        return store;
    }

    @Override
    public void remove(String id) {
        map.remove(id);
    }
}
