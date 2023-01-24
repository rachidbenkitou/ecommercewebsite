package com.medipaf.medipaf.ecommerce.exceptions.NotFoundExceptions;

import com.medipaf.medipaf.ecommerce.exceptions.ApiBaseException;
import org.springframework.http.HttpStatus;

public class CategoryNotFoundException extends ApiBaseException {


    public CategoryNotFoundException(String message){

        super(message);

    }
    @Override
    public HttpStatus getStatusCode() {
        return  HttpStatus.NOT_FOUND;
    }
}
