package com.jokeapi.myjokeapi.joke.exceptions;

public class NoJokeFoundException extends Throwable {
    private static final long serialVersionUID = -2000000000L;

    public NoJokeFoundException(String message) {
        super(message);
    }
}
