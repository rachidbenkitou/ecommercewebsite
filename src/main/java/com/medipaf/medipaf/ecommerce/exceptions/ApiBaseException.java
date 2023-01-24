package com.medipaf.medipaf.ecommerce.exceptions;

import org.springframework.http.HttpStatus;

public abstract class ApiBaseException extends RuntimeException{
    public ApiBaseException(String message){

        super(message);

    }

    // This abstract function returns the status of the exception like (NO_FOUND, BAD_REQUEST and CONFLICT ...)
    public abstract HttpStatus getStatusCode();

}
