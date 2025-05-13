package com.edstem.assessment_02.repository;

import com.edstem.assessment_02.model.WeatherAlert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface WeatherAlertRepository extends JpaRepository<WeatherAlert, Long> {
    List<WeatherAlert> findByTimestampAfter(LocalDateTime time);
    void deleteByTimestampBefore(LocalDateTime time);
}
