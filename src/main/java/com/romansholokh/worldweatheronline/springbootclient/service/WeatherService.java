package com.romansholokh.worldweatheronline.springbootclient.service;

import com.romansholokh.worldweatheronline.springbootclient.entity.Weather;
import com.romansholokh.worldweatheronline.springbootclient.repo.WeatherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class WeatherService {

    private final WeatherRepository weatherRepository;

    public boolean existsWeatherByParams(String city, String date) {

       return weatherRepository.existsWeatherByCityAndDate(city, date);
   }

    public Weather getWeatherByParams(String city, String date) {

        return weatherRepository.findWeatherByCityAndDate(city, date);
    }

    public Weather update(Weather weather) {
        return weatherRepository.save(weather);
    }
}
