package com.jokeapi.myjokeapi.joke;

import com.jokeapi.myjokeapi.database.entities.JokeEntity;
import com.jokeapi.myjokeapi.database.entities.JokeTypeEntity;
import com.jokeapi.myjokeapi.database.entities.LanguageEntity;
import com.jokeapi.myjokeapi.database.repositories.JokeTypesRepo;
import com.jokeapi.myjokeapi.database.repositories.JokesRepo;
import com.jokeapi.myjokeapi.database.repositories.LanguageRepo;
import com.jokeapi.myjokeapi.joke.request.AddJokeRequest;
import com.jokeapi.myjokeapi.joke.request.GetJokeRequest;
import com.jokeapi.myjokeapi.joke.responses.Joke;
import com.jokeapi.myjokeapi.jokeTypes.responses.JokeType;
import com.jokeapi.myjokeapi.languages.responses.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

            var jokes = jokesRepo.findByLanguageAndJokeTypesIn(language, jokeTypes);

            if (jokes.isEmpty()) {
                jokes = jokesRepo.findByLanguage(language);
            }

            int jokeId = (int) Math.floor(Math.random() * jokes.size());
            var selectedJoke = jokes.get(jokeId);

            var typesList = new ArrayList<JokeType>();
            selectedJoke.getJokeTypes().forEach(jt -> typesList.add(new JokeType(jt.getId(), jt.getJokeType())));

            return new Joke(selectedJoke.getId(), selectedJoke.getContent(),
                    new Language(selectedJoke.getLanguage().getId(), selectedJoke.getLanguage().getLanguage()),
                    typesList);
        }catch(Exception e){
            throw new Exception(e);
        }
    }

    public Boolean AddJoke(AddJokeRequest addJokeRequest) throws Exception {
        try{
            var jokeTypes = jokeTypesRepo.findByIdIn(addJokeRequest.jokeTypes);

            var language = languageRepo.findById(addJokeRequest.languageId).get();

            var joke = new JokeEntity(addJokeRequest.joke, language, jokeTypes);

            jokesRepo.save(joke);

            return true;
        }catch(Exception e){
            throw new Exception(e);
        }
    }
}


