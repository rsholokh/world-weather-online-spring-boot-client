package com.romansholokh.worldweatheronline.springbootclient.controller;

import com.romansholokh.worldweatheronline.springbootclient.entity.Weather;
import com.romansholokh.worldweatheronline.springbootclient.service.WeatherService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class WeatherController {

    private WeatherService weatherService;

    @PostMapping("/checkWeather")
    public ResponseEntity getWeather(@RequestBody Weather weather) {

        String city = weather.getCity();
        String date = weather.getDate();

        if (weatherService.existsWeatherByParams(city, date)) {
            weather = weatherService.getWeatherByParams(city, date);
            int numberOfInquiries = weather.getNumberOfInquiries();
            numberOfInquiries++;
            weather.setNumberOfInquiries(numberOfInquiries);
            weatherService.update(weather);

            System.out.println(weather.toString());
            System.out.println("weather record exist in db");

            return null;
        }

        System.out.println("weather record doesnt exist in db");

        return null;
    }
}