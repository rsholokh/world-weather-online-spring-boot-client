package com.romansholokh.worldweatheronline.springbootclient.repo;

import com.romansholokh.worldweatheronline.springbootclient.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Integer> {

    public boolean existsWeatherByCityIgnoreCaseAndDate(String city, String date);

    public Weather findWeatherByCityIgnoreCaseAndDate(String city, String date);
}