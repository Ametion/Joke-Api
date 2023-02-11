package com.jokeapi.myjokeapi.database.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "languages")
public class LanguageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String language;

    private String abbreviation;

    @OneToMany(mappedBy = "language")
    private List<JokeEntity> joke;

    public LanguageEntity(){ }

    public LanguageEntity(String language, String abbreviation) {
        this.language = language;
        this.abbreviation = abbreviation;
    }

    public LanguageEntity(Long id, String language, String abbreviation, List<JokeEntity> joke) {
        this.id = id;
        this.language = language;
        this.abbreviation = abbreviation;
        this.joke = joke;
    }

    public Long getId() {
        return id;
    }

    public String getLanguage() {
        return language;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public List<JokeEntity> getJoke() {
        return joke;
    }
}
