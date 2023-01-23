package hu.fenyvesvolgyimate.vehicleregisterapp.controller;

import hu.fenyvesvolgyimate.vehicleregisterapp.dto.VehicleDTO;

public interface VehicleController {
    void getVehicleByRegistrationNumber(String registrationNumber);
    void registerVehicle(VehicleDTO vehicle);
}
