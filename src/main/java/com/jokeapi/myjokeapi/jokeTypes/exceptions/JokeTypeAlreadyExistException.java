package com.jokeapi.myjokeapi.jokeTypes.exceptions;

public class JokeTypeAlreadyExistException extends Throwable {
    private static final long serialVersionUID = -2000000000L;

    private final String jokeType;

    public String getJokeType() {
        return jokeType;
    }

    public JokeTypeAlreadyExistException(String message, String jokeType) {
        super(message);
        this.jokeType = jokeType;
    }
}
