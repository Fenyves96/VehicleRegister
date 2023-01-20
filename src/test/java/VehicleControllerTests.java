import org.example.controller.JsonVehicleController;
import org.example.controller.VehicleController;

import org.example.exception.InvalidRegisterNumberException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class VehicleControllerTests {
    @Test()
    public void testGetVehicle(){
        VehicleController vehicleController = new JsonVehicleController();
        InvalidRegisterNumberException exception =  assertThrowsExactly(InvalidRegisterNumberException.class, () -> {
            vehicleController.getVehicleByRegisterNumber(null);
        });
    }
}
