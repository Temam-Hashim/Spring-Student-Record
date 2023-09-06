package com.example.demo.exception;

public class ApiRequestException extends RuntimeException {

    public ApiRequestException(String message){
        super(message);
    }
    public ApiRequestException(String message, Throwable couse){
        super(message,couse);
    }


}
