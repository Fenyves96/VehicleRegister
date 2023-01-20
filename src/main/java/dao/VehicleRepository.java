package dao;

import entity.Vehicle;

public interface VehicleRepository {
    void saveVehicle(Vehicle vehicle);
    Vehicle findVehicleByRegistrationNumber(String registrationNumber);
}
