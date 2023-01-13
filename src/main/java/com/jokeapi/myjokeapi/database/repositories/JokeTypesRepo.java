package com.jokeapi.myjokeapi.database.repositories;

import com.jokeapi.myjokeapi.database.entities.JokeTypeEntity;
import org.springframework.data.repository.CrudRepository;

public interface JokeTypesRepo extends CrudRepository<JokeTypeEntity, Long> {

}
