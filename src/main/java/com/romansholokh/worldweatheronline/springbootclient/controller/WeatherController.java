package com.romansholokh.worldweatheronline.springbootclient.controller;

import com.romansholokh.worldweatheronline.springbootclient.entity.Weather;
import com.romansholokh.worldweatheronline.springbootclient.service.WeatherService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class WeatherController {

    private WeatherService weatherService;

    @PostMapping("/checkWeather")
    public ResponseEntity getWeather(@RequestBody Weather weather) throws IOException {

        String city = weather.getCity();
        String date = weather.getDate();

        if (weatherService.existsWeatherByParams(city, date)) {
            weather = weatherService.getWeatherByParams(city, date);
            int numberOfInquiries = weather.getNumberOfInquiries();
            numberOfInquiries++;
            weather.setNumberOfInquiries(numberOfInquiries);
            weatherService.update(weather);

            System.out.println("weather record exist in db");
            System.out.println(weather.toString());

            return ResponseEntity.ok(weather);
        }

        String url = String.format("http://api.worldweatheronline.com/premium/v1/weather.ashx?key=9ef1428da88e444a88c110159210806&q=%s&format=json&num_of_days=1&date=%s&fx=yes&cc=no&mca=no&fx24=no&includelocation=no&show_comments=no&showlocaltime=no&alerts=no&aqi=no",
                city, date);

        String jsonString = weatherService.getWeatherFromUrl(url);

        weather = weatherService.parseWeatherFromJSONResponse(jsonString);

        System.out.println("weather record doesnt exist in db");

        return null;
    }
}