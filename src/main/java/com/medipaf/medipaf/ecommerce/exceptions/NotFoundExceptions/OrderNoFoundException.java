package com.medipaf.medipaf.ecommerce.exceptions.NotFoundExceptions;

import com.medipaf.medipaf.ecommerce.exceptions.ApiBaseException;
import org.springframework.http.HttpStatus;

public class OrderNoFoundException extends ApiBaseException {
    public OrderNoFoundException(String s) {

        super(s);
    }

    @Override
    public HttpStatus getStatusCode() {
        return  HttpStatus.NOT_FOUND;
    }
}
