package hu.fenyvesvolgyimate.vehicleregisterapp.validation;

import hu.fenyvesvolgyimate.vehicleregisterapp.parser.VehicleParser;
import hu.fenyvesvolgyimate.vehicleregisterapp.exception.InvalidRegisterNumberException;

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
