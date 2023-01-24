package hu.fenyvesvolgyimate.vehicleregisterapp.parser;

import hu.fenyvesvolgyimate.vehicleregisterapp.entity.Vehicle;
import org.json.JSONException;
import org.json.JSONObject;

public class VehicleParser {
    JsonParser jsonParser = new JsonParser();

    public String parseVehicleToJson(Vehicle vehicle) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("registrationNumber", vehicle.getRegistrationNumber());
            jsonObject.put("make", vehicle.getMake());
            jsonObject.put("model", vehicle.getModel());
            jsonObject.put("numberOfSeats", vehicle.getNumberOfSeats());
            jsonObject.put("type", vehicle.getVehicleType());
            jsonObject.put("motorEmissionType", vehicle.getMotorEmissionType());
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return jsonObject.toString();
    }

    public Vehicle parseJsonToVehicle(String vehicleJson) {
        String registrationNumber = parseRegistrationNumber(vehicleJson);
        String make = parseMake(vehicleJson);
        String model = parseModel(vehicleJson);
        int numberOfSeats = parseNumberOfSeats(vehicleJson);
        String type = parseType(vehicleJson);
        String motorEmissionType = parseMotorEmissionType(vehicleJson);

        Vehicle vehicle = new Vehicle();
        vehicle.setRegistrationNumber(registrationNumber);
        vehicle.setMake(make);
        vehicle.setModel(model);
        vehicle.setNumberOfSeats(numberOfSeats);
        vehicle.setVehicleType(type);
        vehicle.setMotorEmissionType(motorEmissionType);

        return vehicle;
    }

    private String parseMotorEmissionType(String vehicleJson) {
        return jsonParser.parseStringValueFromJsonStringByKey(vehicleJson ,"motorEmissionType");
    }

    public String parseRegistrationNumber(String vehicleJson) {
        return jsonParser.parseStringValueFromJsonStringByKey(vehicleJson ,"registrationNumber");
    }

    private String parseType(String vehicleJson) {
        return jsonParser.parseStringValueFromJsonStringByKey(vehicleJson, "type");
    }

    private int parseNumberOfSeats(String vehicleJson) {
        return jsonParser.parseIntValueFromJsonStringByKey(vehicleJson, "numberOfSeats");
    }

    private String parseModel(String vehicleJson) {
        return jsonParser.parseStringValueFromJsonStringByKey(vehicleJson, "model");
    }

    private String parseMake(String vehicleJson) {
        return jsonParser.parseStringValueFromJsonStringByKey(vehicleJson, "make");
    }
}
