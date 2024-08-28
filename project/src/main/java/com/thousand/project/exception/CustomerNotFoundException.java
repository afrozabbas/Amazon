package com.thousand.project.exception;

public class CustomerNotFoundException extends RuntimeException{
    public   CustomerNotFoundException(String message){
         super(message);
    }
}
