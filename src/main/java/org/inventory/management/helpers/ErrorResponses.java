package org.inventory.management.helpers;

import im.BaseServiceOuterClass;
/**
 * Utility class for creating error responses related to inventory management operations.
 */
public class ErrorResponses {
    /**
     * Creates an error response indicating that no product exists with the given product ID.
     * @return an error object specifying that the product ID is not found.
     */
    public static BaseServiceOuterClass.Error noProductWithGivenId(){
        return BaseServiceOuterClass.Error.newBuilder()
                .setMessage("No Product exist with the given productId")
                .setType(BaseServiceOuterClass.ErrorType.BAD_REQUEST)
                .build();
    }
    /**
     * Creates an error response indicating that no store exists with the given store ID.
     * @return an error object specifying that the store ID is not found.
     */
    public static BaseServiceOuterClass.Error noStoreWithGivenId(){
        return BaseServiceOuterClass.Error.newBuilder()
                .setMessage("No Store exist with the given storeId")
                .setType(BaseServiceOuterClass.ErrorType.BAD_REQUEST)
                .build();
    }
    /**
     * Creates an error response indicating that no product is registered in the store with the given product ID.
     * @return an error object specifying that the product is not registered for the store.
     */
    public static BaseServiceOuterClass.Error noProductInTheStore(){
        return BaseServiceOuterClass.Error.newBuilder()
                .setMessage("No Product is registered with the given productId for the given storeId")
                .setType(BaseServiceOuterClass.ErrorType.BAD_REQUEST)
                .build();
    }

    /**
     * Creates an error response indicating that a duplicate request has been made for a particular entity.
     * @return an error object specifying that a duplicate request is in progress.
     */
    public static BaseServiceOuterClass.Error duplicateRequest(){
        return BaseServiceOuterClass.Error.newBuilder()
                .setMessage("Duplicate request!!. A request is already in progress for this entity")
                .setType(BaseServiceOuterClass.ErrorType.BAD_REQUEST)
                .build();
    }

    public static BaseServiceOuterClass.Error alreadyExistsRequest(){
        return BaseServiceOuterClass.Error.newBuilder()
                .setMessage("A record already exists for this entity")
                .setType(BaseServiceOuterClass.ErrorType.BAD_REQUEST)
                .build();
    }

}
