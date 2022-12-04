package com.jobdev.consumer.web.client.swapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jobdev.consumer.domain.entity.main.Planet;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class SwapiPlanet {
    @JsonProperty("name")
    private String name;
    @JsonProperty("rotation_period")
    private String rotationPeriod;
    @JsonProperty("orbital_period")
    private String orbitalPeriod;
    @JsonProperty("diameter")
    private String diameter;
    @JsonProperty("climate")
    private String climate;
    @JsonProperty("gravity")
    private String gravity;
    @JsonProperty("terrain")
    private String terrain;
    @JsonProperty("surface_water")
    private String surfaceWater;
    @JsonProperty("population")
    private String population;
    @JsonProperty("created")
    private Date created;
    @JsonProperty("edited")
    private Date edited;
    @JsonProperty("url")
    private String url;
    @JsonProperty("residents")
    private List<String> residents;


    public Planet toEntity() {
        Planet planet = new Planet();
        planet.setName(this.name);
        planet.setRotationPeriod(this.rotationPeriod);
        planet.setOrbitalPeriod(this.orbitalPeriod);
        planet.setDiameter(this.diameter);
        planet.setClimate(this.climate);
        planet.setGravity(this.gravity);
        planet.setTerrain(this.terrain);
        planet.setSurfaceWater(this.surfaceWater);
        planet.setPopulation(this.population);
        planet.setCreated(this.created);
        planet.setEdited(this.edited);
        planet.setUrl(this.url);
        return planet;
    }
}
