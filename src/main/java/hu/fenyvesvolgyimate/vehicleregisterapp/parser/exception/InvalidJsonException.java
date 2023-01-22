package hu.fenyvesvolgyimate.vehicleregisterapp.parser.exception;

public class InvalidJsonException extends RuntimeException {
    @Override
    public String getMessage(){
        return "invalid JSON!";
    }
}
