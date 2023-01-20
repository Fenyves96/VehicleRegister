package org.example.controller;

import org.example.dao.VehicleRepository;
import org.example.entity.Vehicle;
import org.example.exception.InvalidRegisterNumberException;
import org.example.parser.VehicleParser;
import org.example.validation.VehicleValidator;

public class JsonVehicleController implements VehicleController{
    VehicleValidator vehicleValidator;
    VehicleParser vehicleParser;
    VehicleRepository vehicleRepository;
    public JsonVehicleController(){
        vehicleValidator = new VehicleValidator();
    }
    @Override
    public void createVehicle(String vehicleJson) {
        vehicleValidator.validate(vehicleJson);
        String registerNumber = vehicleParser.parseRegisterNumber(vehicleJson);
        Vehicle vehicle = vehicleRepository.findVehicleByRegistrationNumber(registerNumber);

    }

    @Override
    public void getVehicleByRegisterNumber(String registerNumber) {
        if(registerNumber == null)
            throw new InvalidRegisterNumberException();
    }
}
