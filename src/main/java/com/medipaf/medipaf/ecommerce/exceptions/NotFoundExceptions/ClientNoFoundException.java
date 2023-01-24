package com.medipaf.medipaf.ecommerce.exceptions.NotFoundExceptions;

import com.medipaf.medipaf.ecommerce.exceptions.ApiBaseException;
import org.springframework.http.HttpStatus;

public class ClientNoFoundException extends ApiBaseException {
    public ClientNoFoundException(String s) {

        super(s);
    }

    @Override
    public HttpStatus getStatusCode() {
        return  HttpStatus.NOT_FOUND;
    }
}
