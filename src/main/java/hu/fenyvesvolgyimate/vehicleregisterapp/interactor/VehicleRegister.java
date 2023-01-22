package hu.fenyvesvolgyimate.vehicleregisterapp.interactor;

public interface VehicleRegister {
    void register(String vehicleJson);
    void getVehicleByRegisterNumber(String registerNumber);
}
