package com.jokeapi.myjokeapi.languages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LanguageController {
    private static final Logger LOGGER = LogManager.getLogger(LanguageController.class);

    private final LanguageService  languageService;

    @Autowired
    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping("/languages")
    public ResponseEntity GetAllLanguages(){
        try{
            return new ResponseEntity(languageService.GetAllLanguages(), HttpStatus.OK);
        }catch(Exception ex){
            LOGGER.error("ERROR WHILE GETTING ALL LANGUAGES FROM DATABASE: \n" + ex.getMessage());
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
