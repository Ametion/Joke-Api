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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJokeType() {
        return jokeType;
    }

    public void setJokeType(String jokeType) {
        this.jokeType = jokeType;
    }

    public Set<JokeEntity> getJokes() {
        return jokes;
    }

    public void setJokes(Set<JokeEntity> jokes) {
        this.jokes = jokes;
    }
}
