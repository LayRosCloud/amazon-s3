package com.betrayal.amazons3test.exception;

public class BadRequestException extends Exception{
    public BadRequestException(){
        super("Object has bad params");
    }

    public BadRequestException(String message){
        super(message);
    }
}
