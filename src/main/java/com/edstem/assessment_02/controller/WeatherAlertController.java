package com.edstem.assessment_02.controller;

import com.edstem.assessment_02.model.WeatherAlert;
import com.edstem.assessment_02.repository.WeatherAlertRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/alerts")
@RequiredArgsConstructor
public class WeatherAlertController {

    private final WeatherAlertRepository alertRepository;

    @GetMapping("/current")
    public List<WeatherAlert> getCurrentAlerts() {
        System.out.println("Received request for current alerts.");
        LocalDateTime cutoff = LocalDateTime.now().minusHours(1);
        List<WeatherAlert> alerts = alertRepository.findByTimestampAfter(cutoff);
        System.out.println("Fetched alerts: " + alerts);
        return alerts;
    }
}
