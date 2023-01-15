package com.jokeapi.myjokeapi.database.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "jokes")
public class JokeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "language")
    private LanguageEntity language;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "joke_joke_type",
            joinColumns = @JoinColumn(name = "joke_id"),
            inverseJoinColumns = @JoinColumn(name = "joke_type_id"))
    private Set<JokeTypeEntity> jokeTypes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LanguageEntity getLanguage() {
        return language;
    }

    public void setLanguage(LanguageEntity language) {
        this.language = language;
    }

    public Set<JokeTypeEntity> getJokeTypes() {
        return jokeTypes;
    }

    public void setJokeTypes(Set<JokeTypeEntity> jokeTypes) {
        this.jokeTypes = jokeTypes;
    }
}
