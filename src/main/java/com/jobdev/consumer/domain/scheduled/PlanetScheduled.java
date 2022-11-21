package com.jobdev.consumer.domain.scheduled;

import com.jobdev.consumer.domain.repository.PlanetRepository;
import com.jobdev.consumer.web.client.SwapiClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class PlanetScheduled {

    private final SwapiClient swapiClient;
    private final PlanetRepository planetRepository;

    @Scheduled(cron = "${cron.planet}")
    public void chargePlanets() {
        log.info("Starting scheduled task");
        if (planetRepository.count() == 0) {
            var page = 1L;
            var hasNext = true;
            while (hasNext) {
                var response = swapiClient.getPlanets(page);
                var results = response.getResults();
                results.forEach(planetSwapiReponse -> planetRepository.save(planetSwapiReponse.toEntity()));
                hasNext = response.getNext() != null;
                page++;
            }
        }
    }
}
