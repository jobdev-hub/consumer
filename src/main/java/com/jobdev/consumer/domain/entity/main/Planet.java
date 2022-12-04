package com.jobdev.consumer.domain.entity.main;

import com.jobdev.consumer.domain.entity.secondary.People;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Planet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String rotationPeriod;
    private String orbitalPeriod;
    private String diameter;
    private String climate;
    private String gravity;
    private String terrain;
    private String surfaceWater;
    private String population;
    private Date created;
    private Date edited;
    private String url;

    @OneToMany(orphanRemoval = true)
    private List<People> residents = new ArrayList<>();

}