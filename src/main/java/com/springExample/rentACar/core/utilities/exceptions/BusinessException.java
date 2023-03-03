package com.springExample.rentACar.core.utilities.exceptions;

public class BusinessException extends RuntimeException {
    public BusinessException(String brandAlreadyExists) {
        super(brandAlreadyExists);
    }
}
