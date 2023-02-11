package com.jokeapi.myjokeapi.joke;

import com.jokeapi.myjokeapi.database.entities.JokeEntity;
import com.jokeapi.myjokeapi.database.entities.JokeTypeEntity;
import com.jokeapi.myjokeapi.database.entities.LanguageEntity;
import com.jokeapi.myjokeapi.database.repositories.JokeTypesRepo;
import com.jokeapi.myjokeapi.database.repositories.JokesRepo;
import com.jokeapi.myjokeapi.database.repositories.LanguageRepo;
import com.jokeapi.myjokeapi.joke.exceptions.NoJokeFoundException;
import com.jokeapi.myjokeapi.joke.request.AddJokeRequest;
import com.jokeapi.myjokeapi.joke.request.GetJokeRequest;
import com.jokeapi.myjokeapi.joke.responses.Joke;
import com.jokeapi.myjokeapi.jokeTypes.responses.JokeType;
import com.jokeapi.myjokeapi.languages.exceptions.NoLanguageFoundException;
import com.jokeapi.myjokeapi.languages.responses.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
public class JokeService {
    private final JokesRepo jokesRepo;
    private final JokeTypesRepo jokeTypesRepo;
    private final LanguageRepo languageRepo;

    @Autowired
    public JokeService(JokesRepo jokesRepo, JokeTypesRepo jokeTypesRepo, LanguageRepo languageRepo) {
        this.jokesRepo = jokesRepo;
        this.jokeTypesRepo = jokeTypesRepo;
        this.languageRepo = languageRepo;
    }

    public Joke GetJoke(GetJokeRequest getJokeRequest) throws Exception, NoLanguageFoundException, NoJokeFoundException {
        try{
            Set<JokeTypeEntity> jokeTypes = jokeTypesRepo.findByIdIn(getJokeRequest.jokeTypes);
            LanguageEntity language = languageRepo.findById(getJokeRequest.language).get();

            List<JokeEntity> jokes = jokesRepo.findByLanguageAndJokeTypesIn(language, jokeTypes);

            if (jokes.isEmpty()) {
                jokes = jokesRepo.findByLanguage(language);
            }

            if(jokes.isEmpty()){
                throw new NoJokeFoundException("Cam not find jokes with presented parameters");
            }

            int jokeId = (int) Math.floor(Math.random() * jokes.size());
            JokeEntity selectedJoke = jokes.get(jokeId);

            List<JokeType> typesList = new ArrayList<>();
            selectedJoke.getJokeTypes().forEach(jt -> typesList.add(new JokeType(jt.getId(), jt.getJokeType())));

            return new Joke(selectedJoke.getId(), selectedJoke.getContent(),
                    new Language(selectedJoke.getLanguage().getId(), selectedJoke.getLanguage().getAbbreviation(), selectedJoke.getLanguage().getLanguage()), typesList);
        }catch(NoSuchElementException noLanguage) {
            throw new NoLanguageFoundException("Can not find any languages by presented id: " + getJokeRequest.language, getJokeRequest.language);
        }catch (Exception ex){
            throw new Exception(ex);
        }
    }

    public Boolean AddJoke(AddJokeRequest addJokeRequest) throws Exception, NoLanguageFoundException {
        try{
            Set<JokeTypeEntity> jokeTypes = jokeTypesRepo.findByIdIn(addJokeRequest.jokeTypes);

            LanguageEntity language = languageRepo.findById(addJokeRequest.languageId).get();

            JokeEntity joke = new JokeEntity(addJokeRequest.joke, language, jokeTypes);

            jokesRepo.save(joke);

            return true;
        }catch(NoSuchElementException noLanguage) {
            throw new NoLanguageFoundException("Can not find any languages by presented id: " + addJokeRequest.languageId, addJokeRequest.languageId);
        }catch(Exception ex){
            throw new Exception(ex);
        }
    }
}


