package org.example.validation;

import org.example.exception.InvalidRegisterNumberException;
import org.example.parser.VehicleParser;

public class VehicleValidator {
    VehicleParser vehicleParser = new VehicleParser();
    public void validate(String vehicleJson) {
        if(vehicleJson == null)
            throw new InvalidRegisterNumberException();
    }

    public void validateRegistrationNumber(String registrationNumberJson) {
        if(registrationNumberJson == null || vehicleParser.parseRegistrationNumber(registrationNumberJson) == null){
            throw new InvalidRegisterNumberException();
        }
    }
}
