package com.romansholokh.worldweatheronline.springbootclient.controller;

import com.romansholokh.worldweatheronline.springbootclient.entity.Weather;
import com.romansholokh.worldweatheronline.springbootclient.service.WeatherService;
import lombok.AllArgsConstructor;
import org.json.simple.parser.ParseException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class WeatherController {

    private WeatherService weatherService;

    @RequestMapping(value = "/checkWeather", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity requestExample() throws ParseException {
        String jsonRequestExample = "{\"city\":\"London\",\"date\":\"2021-06-10\"}";

        return ResponseEntity.ok(jsonRequestExample);
    }

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

        System.out.println("weather record doesnt exist in db");

        String url = String.format("http://api.worldweatheronline.com/premium/v1/weather.ashx?key=9ef1428da88e444a88c110159210806&q=%s&format=json&num_of_days=1&date=%s&fx=yes&cc=no&mca=no&fx24=no&includelocation=no&show_comments=no&showlocaltime=no&alerts=no&aqi=no",
                city, date);

        String jsonString = weatherService.getWeatherFromUrl(url);

        weather = weatherService.parseWeatherFromJSONResponse(jsonString);

        return ResponseEntity.ok(weatherService.add(weather));
    }
}