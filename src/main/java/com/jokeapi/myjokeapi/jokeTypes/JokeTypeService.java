package com.jokeapi.myjokeapi.jokeTypes;

import com.jokeapi.myjokeapi.database.entities.JokeTypeEntity;
import com.jokeapi.myjokeapi.database.repositories.JokeTypesRepo;
import com.jokeapi.myjokeapi.jokeTypes.responses.JokeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JokeTypeService {
    private final JokeTypesRepo jokeTypesRepo;

    @Autowired
    public JokeTypeService(JokeTypesRepo jokeTypesRepo){
        this.jokeTypesRepo = jokeTypesRepo;
    }

    public List<JokeType> GetAllJokeType() throws Exception{
        try{
            var jokeTypes = jokeTypesRepo.findAll();

            List<JokeType> list = new ArrayList<>();

            for (JokeTypeEntity joke: jokeTypes) {
                list.add(new JokeType(joke.getId(), joke.getJokeType()));
            }

            return list;
        }catch(Exception e){
            throw new Exception(e);
        }
    }
}
