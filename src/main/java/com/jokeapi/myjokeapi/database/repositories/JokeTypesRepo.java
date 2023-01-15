package com.jokeapi.myjokeapi.database.repositories;

import com.jokeapi.myjokeapi.database.entities.JokeTypeEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.Set;

public interface JokeTypesRepo extends CrudRepository<JokeTypeEntity, Long> {
    Set<JokeTypeEntity> findByIdIn(Collection<Long> id);
}
