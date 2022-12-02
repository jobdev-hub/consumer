package com.jobdev.consumer.web.client.swapi.model;

import com.jobdev.consumer.domain.entity.Planet;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SwapiPlanet {
    private String url;
    private String name;
    private String climate;
    private String gravity;
    private String terrain;


    // todo: add object mapper
    public Planet toEntity() {
        Planet planet = new Planet();
        planet.setUrl(this.url);
        planet.setName(this.name);
        planet.setClimate(this.climate);
        planet.setGravity(this.gravity);
        planet.setTerrain(this.terrain);
        return planet;
    }
}
