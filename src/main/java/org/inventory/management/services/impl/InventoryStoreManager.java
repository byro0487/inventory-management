package org.inventory.management.services.impl;

import im.BaseServiceOuterClass;
import im.InventoryManagementServiceOuterClass;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.inventory.management.helpers.ErrorResponses;
import org.inventory.management.helpers.LockManager;
import org.inventory.management.helpers.validators.interfaces.IInventoryValidator;
import org.inventory.management.models.InventoryStore;
import org.inventory.management.models.Store;
import org.inventory.management.repository.interfaces.IRepository;
import org.inventory.management.services.interfaces.IInventoryStoreManager;
import org.inventory.management.services.interfaces.IStoreManager;
/**
 * Manages inventory store operations including adding stores to inventory.
 * This class is responsible for handling business logic associated with inventory management.
 * It utilizes locking mechanisms to ensure thread safety during concurrent data modifications.
 */
@Slf4j
@Setter
public class InventoryStoreManager implements IInventoryStoreManager {

    IInventoryValidator validator;
    IStoreManager storeManager;
    IRepository repository;


    /**
     * Adds a store to an inventory based on the provided request.
     * This method first acquires a lock based on inventory and store IDs to prevent concurrent modifications.
     * It validates the request, retrieves the store details, and updates the inventory store information.
     * If any step fails, it responds with an appropriate error.
     *
     * @param request The request containing details needed to add a store to an inventory.
     * @return A response indicating the success or failure of the operation along with relevant messages.
     */
    @Override
    public InventoryManagementServiceOuterClass.AddStoreToInventoryResponse addStoreToInventory(InventoryManagementServiceOuterClass.AddStoreToInventoryRequest request) {
        InventoryManagementServiceOuterClass.AddStoreToInventoryResponse response= InventoryManagementServiceOuterClass.AddStoreToInventoryResponse.getDefaultInstance();
        String lockKey = request.getInventoryId()+request.getStoreId();
        log.info("Started addStoreToInventory request with inventoryId: {}",request.getInventoryId());
        try{
            if(!LockManager.acquireLock(lockKey)){
                response = response.toBuilder()
                        .setIsSuccess(false)
                        .setError(ErrorResponses.duplicateRequest())
                        .build();
                log.error("Error in addStoreToInventory request with inventoryId: {} with response: {}",request.getInventoryId(),response);
            }
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
                log.error("Error in addStoreToInventory request with inventoryId: {} with response: {}",request.getInventoryId(),response);
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
            log.info("Completed addStoreToInventory request with inventoryId: {} and response: {}",request.getInventoryId(),response);
        }
        catch (Exception e){
            response = response.toBuilder()
                    .setIsSuccess(false)
                    .setError(BaseServiceOuterClass.Error.newBuilder()
                            .setMessage(e.getMessage())
                            .setType(BaseServiceOuterClass.ErrorType.INTERNAL_SERVER_ERROR)
                            .build())
                    .build();
            log.error("Error in addStoreToInventory request with inventoryId: {} with response: {}",request.getInventoryId(),response);
        }
        finally {
            LockManager.releaseLock(lockKey);
        }
        return response;
    }
}
