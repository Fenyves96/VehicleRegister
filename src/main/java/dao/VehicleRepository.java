package dao;

import entity.Vehicle;

public interface VehicleRepository {
    void addVehicle(Vehicle vehicle);
    Vehicle findVehicleByRegistrationNumber(String registrationNumber);
}
