package com.jokeapi.myjokeapi.jokeTypes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class JokeTypeController {
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
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
