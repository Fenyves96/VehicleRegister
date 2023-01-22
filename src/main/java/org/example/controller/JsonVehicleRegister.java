package org.example.controller;

import org.example.dao.VehicleRepository;
import org.example.entity.Vehicle;
import org.example.gui.VehicleUserInterface;
import org.example.parser.VehicleParser;
import org.example.validation.VehicleValidator;

public class JsonVehicleRegister implements VehicleRegister {
    VehicleValidator vehicleValidator;
    VehicleParser vehicleParser;
    VehicleRepository vehicleRepository;
    VehicleUserInterface vehicleUserInterface;
    public JsonVehicleRegister(){
        vehicleValidator = new VehicleValidator();
    }
    @Override
    public void createVehicle(String vehicleJson) {
        vehicleValidator.validate(vehicleJson);
        Vehicle vehicle = vehicleParser.parseJsonToVehicle(vehicleJson);
        vehicleRepository.saveVehicle(vehicle);
        vehicleUserInterface.displayMessage("{\"message\" : \"Sikeres mentés\"}");
    }

    @Override
    public void getVehicleByRegisterNumber(String registrationNumberJson) {
        vehicleValidator.validateRegistrationNumber(registrationNumberJson);
        String registrationNumber = vehicleParser.parseRegistrationNumber(registrationNumberJson);
        Vehicle vehicle = vehicleRepository.findVehicleByRegistrationNumber(registrationNumber);
        String response = vehicleParser.parseVehicleToJson(vehicle);
        vehicleUserInterface.displayVehicle(response);
    }
}
