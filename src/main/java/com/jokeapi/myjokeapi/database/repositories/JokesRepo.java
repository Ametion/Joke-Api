package com.jokeapi.myjokeapi.database.repositories;

import com.jokeapi.myjokeapi.database.entities.JokeEntity;
import com.jokeapi.myjokeapi.database.entities.JokeTypeEntity;
import com.jokeapi.myjokeapi.database.entities.LanguageEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface JokesRepo extends CrudRepository<JokeEntity, Long> {
    List<JokeEntity> findByLanguageAndJokeTypesIn(LanguageEntity language, Collection<JokeTypeEntity> jokeTypes);

    List<JokeEntity> findByLanguage(LanguageEntity language);
}
