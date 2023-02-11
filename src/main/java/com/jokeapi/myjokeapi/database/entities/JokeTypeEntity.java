package com.jokeapi.myjokeapi.database.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "jokeTypes")
public class JokeTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "jokeType", unique = true, nullable = false)
    private String jokeType;

    @ManyToMany(mappedBy = "jokeTypes")
    private Set<JokeEntity> jokes;

    public JokeTypeEntity() { }

    public JokeTypeEntity(String jokeType) {
        this.jokeType = jokeType;
    }

    public JokeTypeEntity(Long id, String jokeType, Set<JokeEntity> jokes) {
        this.id = id;
        this.jokeType = jokeType;
        this.jokes = jokes;
    }

    public Long getId() {
        return id;
    }


    public String getJokeType() {
        return jokeType;
    }


    public Set<JokeEntity> getJokes() {
        return jokes;
    }
}
