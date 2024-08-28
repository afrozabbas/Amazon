package com.thousand.project.exception;

public class WishListNotFoundException extends RuntimeException{
    public WishListNotFoundException(String message){
        super(message);
    }
}
