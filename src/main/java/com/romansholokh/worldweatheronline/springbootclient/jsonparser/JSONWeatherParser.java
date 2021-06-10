package com.romansholokh.worldweatheronline.springbootclient.jsonparser;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class JSONWeatherParser {

    public Map<String, String> parseWeatherFromJSONResponse(String jsonString) {

        JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();

        JsonObject data = (JsonObject) jsonObject.get("data");

        JsonArray request = (JsonArray) data.get("request");
        JsonObject query = request.get(0).getAsJsonObject();
        String cityString = query.get("query").getAsString();

        JsonArray weather = (JsonArray) data.get("weather");
        JsonObject date = weather.get(0).getAsJsonObject();
        String dateString = date.get("date").getAsString();
        String maxTempCString = date.get("maxtempC").getAsString();
        String avgTempCString = date.get("avgtempC").getAsString();
        String minTempCString = date.get("mintempC").getAsString();

        cityString = cityString.substring(0, cityString.lastIndexOf(","));
        maxTempCString = maxTempCString + "°С";
        avgTempCString = avgTempCString + "°С";
        minTempCString = minTempCString + "°С";

        Map<String, String> weatherFields = new HashMap<>();

        weatherFields.put("city", cityString);
        weatherFields.put("date", dateString);
        weatherFields.put("maxTempC", maxTempCString);
        weatherFields.put("avgTempC", avgTempCString);
        weatherFields.put("minTempC", minTempCString);

        System.out.println(cityString);
        System.out.println(dateString);
        System.out.println(maxTempCString);
        System.out.println(avgTempCString);
        System.out.println(minTempCString);

        return weatherFields;
    }

    public JSONObject parseStringToJsonObject(String jsonString) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(jsonString);

        return json;
    }

}