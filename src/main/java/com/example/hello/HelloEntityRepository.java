package com.example.hello;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HelloEntityRepository extends CrudRepository<HelloEntity, Long> {
    Optional<HelloEntity> findByNameEquals(String name);
}
