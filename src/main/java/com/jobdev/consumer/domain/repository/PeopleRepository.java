package com.jobdev.consumer.domain.repository;

import com.jobdev.consumer.domain.entity.secondary.People;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PeopleRepository extends JpaRepository<People, UUID> {

    Optional<People> findByUrl(String url);

}
