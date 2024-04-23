package org.inventory.management.services.impl;

import im.BaseServiceOuterClass;
import im.StoreManagementServiceOuterClass;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.inventory.management.helpers.ErrorResponses;
import org.inventory.management.helpers.LockManager;
import org.inventory.management.helpers.validators.interfaces.IStoreValidator;
import org.inventory.management.models.Product;
import org.inventory.management.models.Store;
import org.inventory.management.models.StoreProduct;
import org.inventory.management.repository.interfaces.IRepository;
import org.inventory.management.services.interfaces.IStoreManager;

@Slf4j
@Setter
public class StoreManager implements IStoreManager {
    IStoreValidator validator;
    IRepository repository;

    @Override
    public StoreManagementServiceOuterClass.AddStoreResponse addStore(StoreManagementServiceOuterClass.AddStoreRequest request) {
        StoreManagementServiceOuterClass.AddStoreResponse response= StoreManagementServiceOuterClass.AddStoreResponse.getDefaultInstance();
        String lockKey = request.getStore().getName();
        log.info("Started addStore request with store name: {}",request.getStore().getName());
        try{
            if(!LockManager.acquireLock(lockKey)){
                response = response.toBuilder()
                        .setIsSuccess(false)
                        .setError(ErrorResponses.duplicateRequest())
                        .build();
                log.error("Error in addStore request with store name: {} with response: {}",request.getStore().getName(),response);
            }

            validator.validateAddStoreRequest(request);
            Store store = Store.fromGRPC(request.getStore());
            Store createdStore = (Store) repository.add(store);

            response = response.toBuilder()
                    .setIsSuccess(true)
                    .setStoreId(createdStore.getId())
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
            log.error("Error in addStore request with store name: {} with response: {}",request.getStore().getName(),response);
        }
        finally {
            LockManager.releaseLock(lockKey);
        }
        log.info("Completed addStore request with store name: {} with response: {}",request.getStore().getName(),response);
        return response;
    }

    @Override
    public Store getStore(String storeId) {
        return (Store) repository.get(storeId);
    }

}
