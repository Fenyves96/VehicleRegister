package hu.fenyvesvolgyimate.vehicleregisterapp.dao;


import hu.fenyvesvolgyimate.vehicleregisterapp.entity.Vehicle;

public interface VehicleRepository {
    void saveVehicle(Vehicle vehicle);
    Vehicle findVehicleByRegistrationNumber(String registrationNumber);
}
