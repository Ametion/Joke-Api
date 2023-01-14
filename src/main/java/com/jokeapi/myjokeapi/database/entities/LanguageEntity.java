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

    @OneToMany(mappedBy = "language")
    private List<JokeEntity> joke;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<JokeEntity> getJoke() {
        return joke;
    }

    public void setJoke(List<JokeEntity> joke) {
        this.joke = joke;
    }
}
