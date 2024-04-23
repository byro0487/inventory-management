package org.inventory.management.services.impl;

import im.BaseServiceOuterClass;
import im.InventoryManagementServiceOuterClass;
import lombok.Setter;
import org.inventory.management.helpers.ErrorResponses;
import org.inventory.management.helpers.validators.interfaces.IInventoryValidator;
import org.inventory.management.models.InventoryStore;
import org.inventory.management.models.Store;
import org.inventory.management.repository.interfaces.IRepository;
import org.inventory.management.services.interfaces.IInventoryStoreManager;
import org.inventory.management.services.interfaces.IStoreManager;


@Setter
public class InventoryStoreManager implements IInventoryStoreManager {

    IInventoryValidator validator;
    IStoreManager storeManager;
    IRepository repository;



    @Override
    public InventoryManagementServiceOuterClass.AddStoreToInventoryResponse addStoreToInventory(InventoryManagementServiceOuterClass.AddStoreToInventoryRequest request) {
        InventoryManagementServiceOuterClass.AddStoreToInventoryResponse response= InventoryManagementServiceOuterClass.AddStoreToInventoryResponse.getDefaultInstance();
        try{
            validator.validateAddStoreToInventoryRequest(request);

            String storeId = request.getStoreId();
            String managerId = request.getManagerId();
            String inventoryId = request.getInventoryId();

            // get store from repo
            Store store = storeManager.getStore(storeId);
            if(store==null){
                response = response.toBuilder()
                        .setIsSuccess(false)
                        .setError(ErrorResponses.noProductWithGivenId())
                        .build();
                return response;
            }
            // Update inventoryId,storeId and managerId
            InventoryStore inventoryStore = InventoryStore.builder()
                    .inventoryId(inventoryId)
                    .storeId(storeId)
                    .managerId(managerId)
                    .build();

            repository.update(inventoryStore);

            response = response.toBuilder()
                    .setIsSuccess(true)
                    .setStoreId(storeId)
                    .build();
        }
        catch (Exception e){
            response = response.toBuilder()
                    .setIsSuccess(false)
                    .setError(BaseServiceOuterClass.Error.newBuilder()
                            .setMessage(e.getMessage())
                            .setType(BaseServiceOuterClass.ErrorType.INTERNAL_SERVER_ERROR)
                            .build())
                    .build();
        }
        return response;
    }
}
