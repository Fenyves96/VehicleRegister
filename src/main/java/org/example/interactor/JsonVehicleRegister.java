package org.example.interactor;

import org.example.dao.VehicleRepository;
import org.example.entity.Vehicle;
import org.example.presenter.VehicleUserInterface;
import org.example.parser.VehicleParser;
import org.example.validation.VehicleValidator;

public class JsonVehicleRegister implements VehicleRegister {
    VehicleValidator vehicleValidator = new VehicleValidator();
    VehicleParser vehicleParser = new VehicleParser();
    VehicleRepository vehicleRepository;
    VehicleUserInterface vehicleUserInterface;

    public JsonVehicleRegister(VehicleRepository vehicleRepository, VehicleUserInterface presenter) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleUserInterface = presenter;
    }

    @Override
    public void register(String vehicleJsonRequest) {
        vehicleValidator.validate(vehicleJsonRequest);
        Vehicle vehicle = vehicleParser.parseJsonToVehicle(vehicleJsonRequest);
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
