package hu.fenyvesvolgyimate.vehicleregisterapp.parser;

import hu.fenyvesvolgyimate.vehicleregisterapp.parser.exception.InvalidJsonException;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonParser {
    public String parseStringValueFromJsonStringByKey(String jsonString, String key) {
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

    public Integer parseIntValueFromJsonStringByKey(String jsonString, String key) {
        String stringValue = parseStringValueFromJsonStringByKey(jsonString, key);
        return Integer.valueOf(stringValue);
    }
}
