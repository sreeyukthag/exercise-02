package com.edstem.assessment_02.service;

import com.edstem.assessment_02.model.WeatherAlert;
import com.edstem.assessment_02.repository.WeatherAlertRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class WeatherScheduler {

    private final MockWeatherService weatherService;
    private final WeatherAlertRepository alertRepository;

    private final List<String> locations = List.of("New York", "London", "Delhi", "Tokyo");

    @Scheduled(fixedRate = 30 * 60 * 1000)
    public void fetchWeatherAndSaveAlert() {
        for (String location : locations) {
            try {
                WeatherAlert alert = weatherService.fetchWeatherData(location);
                alertRepository.save(alert);
                System.out.println("Saved alert for " + location + ": " + alert); // Added logging
            } catch (Exception e) {
                System.err.println("Error fetching alert for " + location + ": " + e.getMessage());
            }
        }
    }

    @Scheduled(cron = "0 0 0 * * *")
    public void purgeOldAlerts() {
        LocalDateTime threshold = LocalDateTime.now().minusDays(3);
        alertRepository.deleteByTimestampBefore(threshold);
        System.out.println("Old alerts purged");
    }
}
