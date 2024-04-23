package org.inventory.management.repository.interfaces;

import org.inventory.management.models.BaseModel;

import java.util.List;

public interface IRepository {
    BaseModel get(String id);
    BaseModel add(BaseModel model);
    BaseModel update(BaseModel model);
    void remove(String id);

}
