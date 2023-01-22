package org.example.controller;

import org.example.dao.VehicleRepository;
import org.example.entity.Vehicle;
import org.example.gui.VehicleConsole;
import org.example.parser.VehicleParser;
import org.example.validation.VehicleValidator;

public class JsonVehicleRegister implements VehicleRegister {
    VehicleValidator vehicleValidator;
    VehicleParser vehicleParser;
    VehicleRepository vehicleRepository;
    VehicleConsole vehicleConsole;
    public JsonVehicleRegister(){
        vehicleValidator = new VehicleValidator();
    }
    @Override
    public void createVehicle(String vehicleJson) {
        vehicleValidator.validate(vehicleJson);
        String registerNumber = vehicleParser.parseRegistrationNumber(vehicleJson);
        Vehicle vehicle = vehicleRepository.findVehicleByRegistrationNumber(registerNumber);
        String response = vehicleParser.parseVehicleToJson(vehicle);
        vehicleConsole.display(response);
    }

    @Override
    public void getVehicleByRegisterNumber(String registrationNumberJson) {
        vehicleValidator.validateRegistrationNumber(registrationNumberJson);
        String registrationNumber = vehicleParser.parseRegistrationNumber(registrationNumberJson);
        Vehicle vehicle = vehicleRepository.findVehicleByRegistrationNumber(registrationNumber);

    }
}
