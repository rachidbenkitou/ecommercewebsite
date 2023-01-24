package com.medipaf.medipaf.ecommerce.handlers;

import org.springframework.stereotype.Service;

@Service
class ErrorDetailsFactoryImpl implements ErrorDetailsFactory {
    @Override
    public ErrorDetails createErrorDetails(String message, String description) {
        return new ErrorDetails(message, description);
    }
}