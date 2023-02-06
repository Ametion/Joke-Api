package com.jokeapi.myjokeapi.languages;

import com.jokeapi.myjokeapi.database.entities.LanguageEntity;
import com.jokeapi.myjokeapi.database.repositories.LanguageRepo;
import com.jokeapi.myjokeapi.languages.responses.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LanguageService {
    private final LanguageRepo languageRepo;

    @Autowired
    public LanguageService(LanguageRepo languageRepo){
        this.languageRepo = languageRepo;
    }

    public List<Language> GetAllLanguages() throws Exception {
        try{
            var languages = languageRepo.findAll();

            List<Language> list = new ArrayList<>();

            for(LanguageEntity lan: languages){
                list.add(new Language(lan.getId(), lan.getLanguage()));
            }

            return list;
        }catch(Exception ex){
            throw new Exception(ex);
        }
    }
}
