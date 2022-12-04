package com.jobdev.consumer.service.scheduled;

import com.jobdev.consumer.domain.repository.PlanetRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class SwapiRemoveLoadScheduled {

    private final PlanetRepository planetRepository;

    @Scheduled(cron = "${cron.swapi-remove-load}")
    public void chargePlanets() {
        log.info("Starting scheduled task [Remove Load]");
        var planets = planetRepository.findAll();
        if (!planets.isEmpty()) {
            planetRepository.deleteById(planets.get(0).getUuid());
        }
    }
}
