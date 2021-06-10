package com.romansholokh.worldweatheronline.springbootclient;

import com.romansholokh.worldweatheronline.springbootclient.controller.WeatherController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class WorldWeatherOnlineSpringBootClientApplicationTests {

    @Autowired
    private WeatherController weatherController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads () throws Exception {
        assertThat(weatherController).isNotNull();
    }

    @Test
    void requestExampleTest () throws Exception {
        this.mockMvc.perform(get("/checkWeather"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("{\"city\":\"London\",\"date\":\"2021-06-10\"}")));
    }


}
