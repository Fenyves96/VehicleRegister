package org.example.parser;

import org.example.entity.Vehicle;
import org.example.parser.exception.InvalidJsonException;
import org.json.JSONException;
import org.json.JSONObject;

public class VehicleParser {
    public String parseRegistrationNumber(String vehicleJson) {
        return parseStringValueFromJsonStringByKey(vehicleJson ,"registrationNumber");
    }

    private String parseStringValueFromJsonStringByKey(String jsonString, String key) {
        String result;
        JSONObject jsonObject = tryParse(jsonString);
        result = getStringValue(jsonObject, key);
        return result;
    }

    private String getStringValue(JSONObject jsonString, String key) {
        String result = null;
        try {
            result = jsonString.getString(key);
        } catch (JSONException e) {
            System.out.println("invalid JsonKey");
        }
        return result;
    }

    private JSONObject tryParse(String outPutFileNameInJson) {
        JSONObject result;
        try {
            result = new JSONObject(outPutFileNameInJson);
        } catch (JSONException e) {
            throw new InvalidJsonException();
        }
        return result;
    }

    private Integer parseIntValueFromJsonStringByKey(String jsonString, String key) {
        String stringValue = parseStringValueFromJsonStringByKey(jsonString, key);
        return Integer.valueOf(stringValue);
    }

    public String parseVehicleToJson(Vehicle vehicle) {
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
        return jsonObject.toString();
    }

    public Vehicle parseJsonToVehicle(String vehicleJson) {
        String registrationNumber = parseRegistrationNumber(vehicleJson);
        String make = parseMake(vehicleJson);
        String model = parseModel(vehicleJson);
        int numberOfSeats = parseNumberOfSeats(vehicleJson);
        String type = parseType(vehicleJson);

        Vehicle vehicle = new Vehicle();
        vehicle.setRegistrationNumber(registrationNumber);
        vehicle.setMake(make);
        vehicle.setModel(model);
        vehicle.setNumberOfSeats(numberOfSeats);
        vehicle.setVehicleType(type);

        return vehicle;
    }

    private String parseType(String vehicleJson) {
        return parseStringValueFromJsonStringByKey(vehicleJson, "type");
    }

    private int parseNumberOfSeats(String vehicleJson) {
        return parseIntValueFromJsonStringByKey(vehicleJson, "numberOfSeats");
    }

    private String parseModel(String vehicleJson) {
        return parseStringValueFromJsonStringByKey(vehicleJson, "model");
    }

    private String parseMake(String vehicleJson) {
        return parseStringValueFromJsonStringByKey(vehicleJson, "make");
    }
}
