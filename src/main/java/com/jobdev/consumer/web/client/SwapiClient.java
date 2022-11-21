package com.jobdev.consumer.web.client;

import com.jobdev.consumer.web.client.model.SwapiPlanetResponse;
import com.jobdev.consumer.web.client.model.SwapiPlanet;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "swapi", url = "${swapi.url}")
public interface SwapiClient {

    @GetMapping("planets/?page={page}")
    SwapiPlanetResponse getPlanets(@PathVariable("page") Long page);

    @GetMapping("planets/{id}")
    SwapiPlanet getPlanetById(@PathVariable String id);

}
