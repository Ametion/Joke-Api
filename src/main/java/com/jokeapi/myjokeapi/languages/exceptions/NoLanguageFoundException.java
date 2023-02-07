package com.jokeapi.myjokeapi.languages.exceptions;

public class NoLanguageFoundException extends Throwable{
    private static final long serialVersionUID = -2000000000L;

    private final Long languageId;

    public Long getLanguageId() {
        return languageId;
    }

    public NoLanguageFoundException(String message, Long languageId) {
        super(message);
        this.languageId = languageId;
    }
}
