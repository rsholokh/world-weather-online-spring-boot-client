package com.romansholokh.worldweatheronline.springbootclient.objectbuilder;

import com.romansholokh.worldweatheronline.springbootclient.entity.Weather;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@AllArgsConstructor
public class WeatherObjectBuilder {

    public Weather buildWeatherObject(Map<String, String> weatherFields) {

        Weather weather = new Weather();

        weather.setCity(weatherFields.get("city"));
        weather.setDate(weatherFields.get("date"));
        weather.setMaxTemp(weatherFields.get("maxTempC"));
        weather.setAvgTemp(weatherFields.get("avgTempC"));
        weather.setMinTemp(weatherFields.get("minTempC"));
        weather.setNumberOfInquiries(0);

        return weather;
    }
}