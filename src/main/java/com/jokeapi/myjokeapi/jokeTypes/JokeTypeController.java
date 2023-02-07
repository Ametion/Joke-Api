package com.jokeapi.myjokeapi.jokeTypes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class JokeTypeController {
    private static final Logger LOGGER = LogManager.getLogger(JokeTypeController.class);

    private final JokeTypeService jokeTypeService;

    @Autowired
    public JokeTypeController(JokeTypeService jokeTypeService){
        this.jokeTypeService = jokeTypeService;
    }

    @GetMapping("/jokeTypes")
    public ResponseEntity GetJokeTypeById() {
        try{
            return new ResponseEntity(jokeTypeService.GetAllJokeType(), HttpStatus.OK);
        }catch(Exception ex){
            LOGGER.error("ERROR WHILE GETTING ALL JOKE TYPES FROM DATABASE: \n" + ex.getMessage());
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
