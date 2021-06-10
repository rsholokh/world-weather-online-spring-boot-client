package com.romansholokh.worldweatheronline.springbootclient;

import com.romansholokh.worldweatheronline.springbootclient.entity.Weather;
import com.romansholokh.worldweatheronline.springbootclient.repo.WeatherRepository;
import com.romansholokh.worldweatheronline.springbootclient.service.WeatherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class WeatherServiceTest {

    @Mock
    private WeatherRepository weatherRepository;
    @InjectMocks
    private WeatherService weatherService;

    @Test
    public void whenSaveWeather_shouldReturnWeather() {
        Weather weather = new Weather();
        weather.setCity("London");
        weather.setDate("2021-06-10");
        weather.setMaxTemp("30°С");
        weather.setAvgTemp("25°С");
        weather.setMinTemp("20°С");
        weather.setNumberOfInquiries(0);
        when(weatherRepository.save(ArgumentMatchers.any(Weather.class))).thenReturn(weather);
        Weather created = weatherService.add(weather);
        assertThat(created.getCity()).isSameAs(weather.getCity());
        assertThat(created.getDate()).isSameAs(weather.getDate());
        assertThat(created.getMaxTemp()).isSameAs(weather.getMaxTemp());
        assertThat(created.getAvgTemp()).isSameAs(weather.getAvgTemp());
        assertThat(created.getMinTemp()).isSameAs(weather.getMinTemp());
        assertThat(created.getNumberOfInquiries()).isSameAs(weather.getNumberOfInquiries());
        verify(weatherRepository).save(weather);
    }

    @Test
    public void whenGivenCityAndDate_shouldReturnWeather_ifExists() {
        Weather weather = new Weather();
        weather.setCity("London");
        weather.setDate("2021-06-10");
        weather.setMaxTemp("30°С");
        weather.setAvgTemp("25°С");
        weather.setMinTemp("20°С");
        weather.setNumberOfInquiries(0);
        weatherService.add(weather);
        when(weatherRepository.findWeatherByCityIgnoreCaseAndDate("London", "2021-06-10"))
                .thenReturn(weather);
        Weather created = weatherService.getWeatherByParams(weather.getCity(), weather.getDate());
        assertThat(created.getCity()).isSameAs(weather.getCity());
        assertThat(created.getDate()).isSameAs(weather.getDate());

    }

}
