package com.johnverz.webdev1_g1.exception;

public class UsernameNotFoundException extends RuntimeException{
    UsernameNotFoundException(String message){
        super(message);
    }
}
