package com.jobdev.consumer.service.scheduled;

import com.jobdev.consumer.domain.entity.main.Planet;
import com.jobdev.consumer.domain.repository.PeopleRepository;
import com.jobdev.consumer.domain.repository.PlanetRepository;
import com.jobdev.consumer.web.client.swapi.SwapiClient;
import com.jobdev.consumer.web.client.swapi.model.SwapiPlanet;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class SwapiInitialLoadScheduled {

    private final SwapiClient swapiClient;
    private final PlanetRepository planetRepository;
    private final PeopleRepository peopleRepository;

    @Scheduled(cron = "${cron.swapi-initial-load}")
    public void loadPlanets() {
        log.info("Starting scheduled task [Initial Load]");
        if (planetRepository.count() == 0) {
            var page = 1L;
            var hasNext = true;
            while (hasNext) {
                var response = swapiClient.getPlanets(page);
                for (SwapiPlanet planetSwapiResponse : response.getResults()) {
                    var planet = planetSwapiResponse.toEntity();
                    if (!planetSwapiResponse.getResidents().isEmpty()) {
                        loadResidents(planetSwapiResponse, planet);
                    }
                    planetRepository.save(planet);
                }
                hasNext = response.getNext() != null;
                page++;
            }
        }
    }

    private void loadResidents(SwapiPlanet planetSwapiResponse, Planet planet) {
        for (String urlResident : planetSwapiResponse.getResidents()) {
            var people = peopleRepository.findByUrl(urlResident);
            if (people.isPresent()) {
                planet.getResidents().add(people.get());
            } else {
                var url = urlResident.substring(0, urlResident.length() - 1);
                var id = url.substring(url.lastIndexOf("/") + 1);
                var swapiPeople = swapiClient.getPeople(id);
                var peopleEntity = swapiPeople.toEntity();
                var newPeople = peopleRepository.save(peopleEntity);
                planet.getResidents().add(newPeople);
            }
        }
    }
}
