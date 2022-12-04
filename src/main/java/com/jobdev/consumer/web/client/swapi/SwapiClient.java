package com.jobdev.consumer.web.client.swapi;

import com.jobdev.consumer.web.client.swapi.model.SwapiPeople;
import com.jobdev.consumer.web.client.swapi.model.SwapiPlanet;
import com.jobdev.consumer.web.client.swapi.model.SwapiPlanetResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "swapi", url = "${swapi.url}")
public interface SwapiClient {

    @GetMapping("planets/?page={page}")
    SwapiPlanetResponse getPlanets(@PathVariable("page") Long page);

    @GetMapping("planets/{id}")
    SwapiPlanet getPlanetById(@PathVariable String id);

    @GetMapping("people/{id}")
    SwapiPeople getPeople(@PathVariable String id);

}
