package com.ingemark.products.exceptions;

public class DuplicateCodeException extends RuntimeException{
    public DuplicateCodeException(String msg) {
        super(msg);
    }
}
