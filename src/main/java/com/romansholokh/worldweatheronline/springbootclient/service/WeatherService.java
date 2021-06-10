package com.romansholokh.worldweatheronline.springbootclient.service;

import com.romansholokh.worldweatheronline.springbootclient.entity.Weather;
import com.romansholokh.worldweatheronline.springbootclient.jsonparser.JSONParser;
import com.romansholokh.worldweatheronline.springbootclient.objectbuilder.WeatherObjectBuilder;
import com.romansholokh.worldweatheronline.springbootclient.okhttp.OkHttp;
import com.romansholokh.worldweatheronline.springbootclient.repo.WeatherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
@Transactional
@AllArgsConstructor
public class WeatherService {

    private final WeatherRepository weatherRepository;
    private final OkHttp client;
    private final JSONParser jsonParser;
    private final WeatherObjectBuilder weatherObjectBuilder;

    public boolean existsWeatherByParams(String city, String date) {

       return weatherRepository.existsWeatherByCityAndDate(city, date);
   }

    public Weather getWeatherByParams(String city, String date) {

        return weatherRepository.findWeatherByCityAndDate(city, date);
    }

    public Weather update(Weather weather) {
        return weatherRepository.save(weather);
    }

    public String getWeatherFromUrl(String url) throws IOException {
        return client.getFromUrl(url);
    }

    public Weather parseWeatherFromJSONResponse(String jsonString) {

        return weatherObjectBuilder.buildWeatherObject(jsonParser.parseWeatherFromJSONResponse(jsonString));
    }
}
