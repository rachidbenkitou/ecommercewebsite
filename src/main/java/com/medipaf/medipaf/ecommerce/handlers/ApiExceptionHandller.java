package com.medipaf.medipaf.ecommerce.handlers;

import com.medipaf.medipaf.ecommerce.exceptions.ApiBaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

// When ApiBaseException thrown, the class handleApiExceptions will be automatically generated
// This class returns the status of the error (like not_found and bad_request) also errorDetails as we defined
// in the ErrorDetails Class (Message, Url, Time and Date)
@ControllerAdvice
public class ApiExceptionHandller extends ResponseEntityExceptionHandler {

    @Autowired
    private   ErrorDetailsFactory errorDetailsFactory;


    @ExceptionHandler(ApiBaseException.class)
    public ResponseEntity<ErrorDetails> handleApiExceptions(ApiBaseException cx, WebRequest request){

        ErrorDetails errorDetails  = errorDetailsFactory.createErrorDetails(cx.getMessage(), request.getDescription(false));

        return  new ResponseEntity<>(errorDetails,  cx.getStatusCode());

    }

}
