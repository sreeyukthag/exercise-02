package com.edstem.assessment_02.service;

import com.edstem.assessment_02.model.WeatherAlert;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class MockWeatherService {

    private final Random random = new Random();

    public WeatherAlert fetchWeatherData(String location) {
        double temperature = 20 + random.nextDouble() * 20;
        double humidity = 40 + random.nextDouble() * 40;
        String alertLevel = determineAlertLevel(temperature);

        WeatherAlert alert = new WeatherAlert(
                null,
                location,
                temperature,
                humidity,
                alertLevel,
                LocalDateTime.now()
        );
        System.out.println("Weather Alert created: " + alert);
        return alert;
    }

    private String determineAlertLevel(double temperature) {
        if (temperature > 35) return "HIGH";
        else if (temperature > 30) return "MODERATE";
        else return "NORMAL";
    }
}
