package com.example.demo.exception;

public class InvalidBodyException extends RuntimeException{

    public InvalidBodyException(String message){
        super(message);
    }
}
