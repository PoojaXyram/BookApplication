package com.enterprise.bookapplication.exceptions;


public class ResourceNotFound extends RuntimeException {
    String resorceName;
    Integer fieldValue;

    public ResourceNotFound(String resorceName,
                            Integer fieldValue) {
        super(String.format("%s not found with %d ", resorceName, fieldValue));
        this.resorceName = resorceName;
        this.fieldValue = fieldValue;
    }
}
