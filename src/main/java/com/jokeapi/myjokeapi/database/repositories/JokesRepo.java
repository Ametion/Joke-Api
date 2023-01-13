package com.jokeapi.myjokeapi.database.repositories;

import com.jokeapi.myjokeapi.database.entities.JokeEntity;
import com.jokeapi.myjokeapi.database.entities.JokeTypeEntity;
import org.springframework.data.repository.CrudRepository;

public interface JokesRepo extends CrudRepository<JokeEntity, Long> {
    JokeEntity findByJokeTypes(JokeTypeEntity jokeType);
}
