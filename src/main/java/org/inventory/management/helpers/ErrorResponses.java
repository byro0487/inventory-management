package org.inventory.management.helpers;

import im.BaseServiceOuterClass;

public class ErrorResponses {

    public static BaseServiceOuterClass.Error noProductWithGivenId(){
        return BaseServiceOuterClass.Error.newBuilder()
                .setMessage("No Product exist with the given productId")
                .setType(BaseServiceOuterClass.ErrorType.BAD_REQUEST)
                .build();
    }

    public static BaseServiceOuterClass.Error noProductInTheStore(){
        return BaseServiceOuterClass.Error.newBuilder()
                .setMessage("No Product is registered with the given productId for the given storeId")
                .setType(BaseServiceOuterClass.ErrorType.BAD_REQUEST)
                .build();
    }

    public static BaseServiceOuterClass.Error duplicateRequest(){
        return BaseServiceOuterClass.Error.newBuilder()
                .setMessage("Duplicate request!!. A request is already in progress for this entity")
                .setType(BaseServiceOuterClass.ErrorType.BAD_REQUEST)
                .build();
    }

}
