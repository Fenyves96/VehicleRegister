package org.example.controller;

public interface VehicleRegister {
    void createVehicle(String vehicleJson);
    void getVehicleByRegisterNumber(String registerNumber);
}
