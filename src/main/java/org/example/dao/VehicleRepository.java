package org.example.dao;


import org.example.entity.Vehicle;

public interface VehicleRepository {
    void saveVehicle(Vehicle vehicle);
    Vehicle findVehicleByRegistrationNumber(String registrationNumber);
}
