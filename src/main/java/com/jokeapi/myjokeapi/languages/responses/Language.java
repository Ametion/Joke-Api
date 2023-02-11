package com.jokeapi.myjokeapi.languages.responses;

public class Language {
    public final long languageId;
    public final String languageAbbreviation;
    public final String language;

    public Language(long languageId, String languageAbbreviation, String language) {
        this.languageId = languageId;
        this.languageAbbreviation = languageAbbreviation;
        this.language = language;
    }
}
