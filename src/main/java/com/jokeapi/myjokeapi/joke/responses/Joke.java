package com.jokeapi.myjokeapi.joke.responses;

import com.jokeapi.myjokeapi.jokeTypes.responses.JokeType;
import com.jokeapi.myjokeapi.languages.responses.Language;

import java.util.Collection;

public class Joke{
    public final long jokeId;
    public final String joke;
    public final Language language;
    public final Collection<JokeType> jokeTypes;

    public Joke(long jokeId, String joke, Language language, Collection<JokeType> jokeTypes) {
        this.jokeId = jokeId;
        this.joke = joke;
        this.language = language;
        this.jokeTypes = jokeTypes;
    }
}
