package com.jobdev.consumer.web.client.swapi.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class SwapiPlanetResponse {
    Integer count;
    String next;
    String previous;
    List<SwapiPlanet> results;
}
