package org.inventory.management.repository.impl;

import org.inventory.management.models.BaseModel;
import org.inventory.management.models.InventoryStore;
import org.inventory.management.repository.interfaces.IRepository;

import java.util.HashMap;
import java.util.Map;


public class InventoryStoreRepository implements IRepository {
    private static Map<String, InventoryStore> map = new HashMap<>();
    @Override
    public BaseModel get(String id) {
        return map.get(id);
    }

    @Override
    public BaseModel add(BaseModel model) {
        InventoryStore inventoryStore = (InventoryStore)model;
        String id = createId(inventoryStore);
        inventoryStore.setId(id);
        map.put(id,inventoryStore);
        return inventoryStore;
    }

    @Override
    public BaseModel update(BaseModel model) {
        InventoryStore inventoryStore = (InventoryStore)model;
        String id = createId(inventoryStore);
        map.put(id,inventoryStore);
        return inventoryStore;
    }

    @Override
    public void remove(String id) {
        map.remove(id);
    }

    private String createId(InventoryStore inventoryStore){
        return "InventoryStore:"+inventoryStore.getInventoryId()+":"+inventoryStore.getStoreId();
    }
}
