package com.jobdev.consumer.web.consumer;

import com.jobdev.consumer.web.response.PlanetListSwapiReponse;
import com.jobdev.consumer.web.response.PlanetSwapiReponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "swapi", url = "https://swapi.dev/api/")
public interface SwapiConsumer {

    @GetMapping("planets/?page={page}")
    PlanetListSwapiReponse getPlanets(@PathVariable("page") Long page);

    @GetMapping("planets/{id}")
    PlanetSwapiReponse getPlanetById(@PathVariable String id);

}
