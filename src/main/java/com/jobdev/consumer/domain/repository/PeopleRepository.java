package com.jobdev.consumer.domain.repository;

import com.jobdev.consumer.domain.entity.secondary.People;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PeopleRepository extends JpaRepository<People, Long> {

    Optional<People> findByUrl(String url);

}
