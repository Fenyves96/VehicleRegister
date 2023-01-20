package org.example.validation;

import org.example.exception.InvalidRegisterNumberException;

public class VehicleValidator {
    public void validate(String vehicleJson) {
        if(vehicleJson == null)
            throw new InvalidRegisterNumberException();
    }
}
