package com.jokeapi.myjokeapi.jokeTypes;

import com.jokeapi.myjokeapi.database.repositories.JokeTypesRepo;
import com.jokeapi.myjokeapi.jokeTypes.responses.JokeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JokeTypeService {
    private JokeTypesRepo jokeTypesRepo;

    @Autowired
    public JokeTypeService(JokeTypesRepo jokeTypesRepo){
        this.jokeTypesRepo = jokeTypesRepo;
    }

    public Object GetAllJokeType() throws Exception{
        try{
            var jokeTypes = jokeTypesRepo.findAll();

            var list = new ArrayList<JokeType>();

            for (var joke: jokeTypes) {
                list.add(new JokeType(joke.getId(), joke.getJokeType()));
            }

            return list;
        }catch(Exception e){
            throw new Exception(e);
        }
    }
}
