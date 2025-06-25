package utils;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

public class JsonObjectsUtils {
    public static JSONObject createStatusObject(String code, String description) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", code);
        jsonObject.put("description", description);
        return jsonObject;
    }
    public static JSONObject createAgreementsJSONObject(String value1, Boolean value2, String value3) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", value1);
        jsonObject.put("approved", value2);
        jsonObject.put("activeVersion", value3);
        return jsonObject;
    }
    public static JSONObject createJSONObject(String key, String value) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(key, value);
        return jsonObject;
    }
    public static JSONObject createJSONObject(String key, double value) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(key, value);
        return jsonObject;
    }
    public static JSONObject createJSONObject(String key, boolean value) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(key, value);
        return jsonObject;
    }
    public static JSONObject createJSONObject(String key, JSONObject value) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(key, value);
        return jsonObject;
    }

    public static JSONObject createJSONObject(String key, JSONArray value) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(key, value);
        return jsonObject;
    }
    public static JSONObject mergeJSONObjects(JSONObject... jsonObjects) {
        JSONObject mergedObject = new JSONObject();
        for (JSONObject obj : jsonObjects) {
            for (String key : obj.keySet()) {
                mergedObject.put(key, obj.get(key));
            }
        }
        return mergedObject;
    }
}
