package com.jokeapi.myjokeapi.languages.exceptions;

public class LanguageAlreadyExistException extends Throwable {
    private static final long serialVersionUID = -2000000000L;

    private final String abbreviation;

    public String getAbbreviation() {
        return abbreviation;
    }

    public LanguageAlreadyExistException(String message, String abbreviation) {
        super(message);
        this.abbreviation = abbreviation;
    }
}
