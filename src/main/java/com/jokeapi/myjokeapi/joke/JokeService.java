package com.jokeapi.myjokeapi.joke;

import com.jokeapi.myjokeapi.database.entities.JokeEntity;
import com.jokeapi.myjokeapi.database.repositories.JokeTypesRepo;
import com.jokeapi.myjokeapi.database.repositories.JokesRepo;
import com.jokeapi.myjokeapi.database.repositories.LanguageRepo;
import com.jokeapi.myjokeapi.joke.request.GetJokeRequest;
import com.jokeapi.myjokeapi.joke.responses.Joke;
import com.jokeapi.myjokeapi.jokeTypes.responses.JokeType;
import com.jokeapi.myjokeapi.languages.responses.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;

@Service
public class JokeService {
    private JokesRepo jokesRepo;
    private JokeTypesRepo jokeTypesRepo;
    private LanguageRepo languageRepo;

    @Autowired
    public JokeService(JokesRepo jokesRepo, JokeTypesRepo jokeTypesRepo, LanguageRepo languageRepo) {
        this.jokesRepo = jokesRepo;
        this.jokeTypesRepo = jokeTypesRepo;
        this.languageRepo = languageRepo;
    }

    public Joke GetJoke(GetJokeRequest getJokeRequest) throws Exception {
        try{
            var jokeTypes = jokeTypesRepo.findByIdIn(getJokeRequest.jokeTypes);

            var language = languageRepo.findById(getJokeRequest.language).get();

            var joke = (ArrayList<JokeEntity>)jokesRepo.findAll();

            var jokeList = new ArrayList<JokeEntity>();

            joke.forEach(j -> {
                if (!jokeTypes.isEmpty()) {
                    if(CollectionUtils.containsAny(j.getJokeTypes(), jokeTypes) && j.getLanguage().equals(language)){
                        jokeList.add(j);
                    }
                }
                else{
                    if(j.getLanguage().equals(language)){
                        jokeList.add(j);
                    }
                }
            });

            int jokeId = (int)Math.floor(Math.random() * (jokeList.size()));

            var typesList = new ArrayList<JokeType>();

            jokeList.get(jokeId).getJokeTypes().forEach(j -> typesList.add(new JokeType(j.getId(), j.getJokeType())));

            return new Joke(jokeList.get(jokeId).getId(), jokeList.get(jokeId).getContent(),
                    new Language(jokeList.get(jokeId).getLanguage().getId(), jokeList.get(jokeId).getLanguage().getLanguage()),
                    typesList);
        }catch(Exception e){
            throw new Exception(e);
        }
    }
}


