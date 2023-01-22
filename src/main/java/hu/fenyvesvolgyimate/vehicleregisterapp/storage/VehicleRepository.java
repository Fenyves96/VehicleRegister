package hu.fenyvesvolgyimate.vehicleregisterapp.storage;


import hu.fenyvesvolgyimate.vehicleregisterapp.entity.Vehicle;

public interface VehicleRepository {
    void saveVehicle(Vehicle vehicle);
    Vehicle findVehicleByRegistrationNumber(String registrationNumber);
}
