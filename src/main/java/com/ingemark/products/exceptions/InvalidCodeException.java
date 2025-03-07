package com.ingemark.products.exceptions;

public class InvalidCodeException extends RuntimeException{
    public InvalidCodeException(String msg) {
        super(msg);
    }
}
