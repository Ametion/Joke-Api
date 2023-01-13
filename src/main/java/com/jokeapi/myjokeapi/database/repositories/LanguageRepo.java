package com.jokeapi.myjokeapi.database.repositories;

import com.jokeapi.myjokeapi.database.entities.LanguageEntity;
import org.springframework.data.repository.CrudRepository;

public interface LanguageRepo extends CrudRepository<LanguageEntity, Long> {
}
