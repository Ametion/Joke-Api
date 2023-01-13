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
}
