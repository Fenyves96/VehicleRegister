package hu.fenyvesvolgyimate.vehicleregisterapp.parser;

import hu.fenyvesvolgyimate.vehicleregisterapp.entity.Vehicle;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleParserTests {
    VehicleParser vehicleParser = new VehicleParser();

    @Test
    void parseRegisterNumber() {
        String registrationNumber = "ABC-123";
        String parsedRegistrationNumber =
                vehicleParser.parseRegistrationNumber("{\"registrationNumber\" : \"%s\"}".formatted(registrationNumber));
        assertEquals(registrationNumber, parsedRegistrationNumber);
    }

    @Test
    void parseVehicleToJson() {
        Vehicle vehicle = createOpelAstra();
        JSONObject jsonObject = generateJsonFromVehicle(vehicle);
        assertEquals(jsonObject.toString(), vehicleParser.parseVehicleToJson(vehicle));
    }

    @Test
    void parseJsonToVehicle (){
        Vehicle vehicle = createOpelAstra();
        Vehicle vehicleResult = vehicleParser.parseJsonToVehicle(generateJsonFromVehicle(vehicle).toString());

        assertEquals(vehicleResult.getRegistrationNumber(), vehicle.getRegistrationNumber());
        assertEquals(vehicleResult.getMake(), vehicle.getMake());
        assertEquals(vehicleResult.getModel(), vehicle.getModel());
        assertEquals(vehicleResult.getNumberOfSeats(), vehicle.getNumberOfSeats());
        assertEquals(vehicleResult.getVehicleType(), vehicle.getVehicleType());
    }

    private static JSONObject generateJsonFromVehicle(Vehicle vehicle) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("registrationNumber", vehicle.getRegistrationNumber());
            jsonObject.put("make", vehicle.getMake());
            jsonObject.put("model", vehicle.getModel());
            jsonObject.put("numberOfSeats", vehicle.getNumberOfSeats());
            jsonObject.put("type", vehicle.getVehicleType());
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return jsonObject;
    }

    private static Vehicle createOpelAstra() {
        Vehicle vehicle = new Vehicle();
        vehicle.setMake("Opel");
        vehicle.setModel("Astra");
        vehicle.setNumberOfSeats(5);
        vehicle.setVehicleType("m3");
        vehicle.setRegistrationNumber("ABC-123");
        return vehicle;
    }


}