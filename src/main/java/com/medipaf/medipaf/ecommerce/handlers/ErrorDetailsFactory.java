package com.medipaf.medipaf.ecommerce.handlers;

interface ErrorDetailsFactory {
    ErrorDetails createErrorDetails(String message, String description);
}