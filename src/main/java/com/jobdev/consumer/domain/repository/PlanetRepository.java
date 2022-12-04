package com.jobdev.consumer.domain.repository;

import com.jobdev.consumer.domain.entity.main.Planet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanetRepository extends JpaRepository<Planet, Long> {

}
