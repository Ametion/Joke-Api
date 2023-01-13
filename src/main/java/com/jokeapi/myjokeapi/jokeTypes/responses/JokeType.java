package com.jokeapi.myjokeapi.jokeTypes.responses;

public class JokeType {
    public final Long jokeTypeId;
    public final String jokeType;

    public JokeType(Long jokeTypeId, String jokeType) {
        this.jokeTypeId = jokeTypeId;
        this.jokeType = jokeType;
    }
}
