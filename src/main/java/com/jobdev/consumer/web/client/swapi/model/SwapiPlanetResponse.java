package com.jobdev.consumer.web.client.swapi.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SwapiPlanetResponse {
    Integer count;
    String next;
    String previous;
    List<SwapiPlanet> results;
}
