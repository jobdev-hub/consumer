package com.jobdev.consumer.web.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class PlanetListSwapiReponse {
    Integer count;
    String next;
    String previous;
    List<PlanetSwapiReponse> results;
}
