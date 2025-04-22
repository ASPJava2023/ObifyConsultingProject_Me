package com.asp.ObifyConsulting.exception;

public class PropertyNotFoundExceptionCustom extends RuntimeException{
    private String msg;

    public PropertyNotFoundExceptionCustom(String message) {
        super(message);
        this.msg = msg;
    }
}
