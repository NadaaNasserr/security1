package com.example.security.API;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;



public class ApiException extends RuntimeException{
    public ApiException(String message){
        super(message);
    }
}