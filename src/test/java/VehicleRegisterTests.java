import org.example.controller.JsonVehicleRegister;
import org.example.controller.VehicleRegister;

import org.example.exception.InvalidRegisterNumberException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class VehicleRegisterTests {
    @Test()
    public void testGetVehicle(){
        VehicleRegister vehicleRegister = new JsonVehicleRegister();
        assertThrowsExactly(InvalidRegisterNumberException.class, () -> {
            vehicleRegister.getVehicleByRegisterNumber(null);
        });
    }
}
