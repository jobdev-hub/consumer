package com.jobdev.consumer.web.client.swapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jobdev.consumer.domain.entity.secondary.People;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SwapiPeople {
    @JsonProperty("name")
    private String name;
    @JsonProperty("url")
    private String url;
    @JsonProperty("homeworld")
    private String homeworld;

    public People toEntity() {
        People people = new People();
        people.setName(this.name);
        people.setUrl(this.url);
        people.setHomeworld(this.homeworld);
        return people;
    }
}
