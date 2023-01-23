package hu.fenyvesvolgyimate.vehicleregisterapp.interactor;

import hu.fenyvesvolgyimate.vehicleregisterapp.storage.VehicleRepository;
import hu.fenyvesvolgyimate.vehicleregisterapp.entity.Vehicle;
import hu.fenyvesvolgyimate.vehicleregisterapp.presenter.VehiclePresenter;
import hu.fenyvesvolgyimate.vehicleregisterapp.parser.VehicleParser;
import hu.fenyvesvolgyimate.vehicleregisterapp.validation.VehicleValidator;

public class JsonVehicleRegister implements VehicleRegister {
    VehicleValidator vehicleValidator = new VehicleValidator();
    VehicleParser vehicleParser = new VehicleParser();
    VehicleRepository vehicleRepository;
    VehiclePresenter vehiclePresenter;

    public JsonVehicleRegister(VehicleRepository vehicleRepository, VehiclePresenter presenter) {
        this.vehicleRepository = vehicleRepository;
        this.vehiclePresenter = presenter;
    }

    @Override
    public void register(String vehicleJsonRequest) {
        vehicleValidator.validate(vehicleJsonRequest);
        Vehicle vehicle = vehicleParser.parseJsonToVehicle(vehicleJsonRequest);
        vehicleRepository.saveVehicle(vehicle);
        vehiclePresenter.displayMessage("{\"message\" : \"Sikeres mentés\"}");
    }

    @Override
    public void getVehicleByRegisterNumber(String registrationNumberJson) {
        vehicleValidator.validateRegistrationNumber(registrationNumberJson);
        String registrationNumber = vehicleParser.parseRegistrationNumber(registrationNumberJson);
        Vehicle vehicle = vehicleRepository.findVehicleByRegistrationNumber(registrationNumber);
        String response = vehicleParser.parseVehicleToJson(vehicle);
        vehiclePresenter.displayVehicle(response);
    }
}
