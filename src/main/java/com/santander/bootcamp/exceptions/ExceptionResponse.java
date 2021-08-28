package com.santander.bootcamp.exceptions;

public class ExceptionResponse {

    public String message;

    public ExceptionResponse(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
