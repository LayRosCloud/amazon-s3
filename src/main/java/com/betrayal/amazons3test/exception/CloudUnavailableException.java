package com.betrayal.amazons3test.exception;

public class CloudUnavailableException extends Exception {
    public CloudUnavailableException(){
        super("Cloud is unavailable");
    }

    public CloudUnavailableException(String message){
        super(message);
    }
}
