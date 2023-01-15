package com.jokeapi.myjokeapi.joke.request;

import java.util.List;

public class AddJokeRequest {
    public Long languageId;
    public List<Long> jokeTypes;
    public String joke;
}
