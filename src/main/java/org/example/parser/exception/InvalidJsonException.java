package org.example.parser.exception;

public class InvalidJsonException extends RuntimeException {
    @Override
    public String getMessage(){
        return "invalid JSON!";
    }
}
