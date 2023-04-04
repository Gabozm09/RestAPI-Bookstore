package com.bookstore.restapi.ErrorHandling;

public class DuplicateIsbnException extends RuntimeException {
    public DuplicateIsbnException(String message) {
        super(message);
    }
}
