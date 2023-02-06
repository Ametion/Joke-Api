package com.jokeapi.myjokeapi.joke;

import com.jokeapi.myjokeapi.joke.request.AddJokeRequest;
import com.jokeapi.myjokeapi.joke.request.GetJokeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class JokeController {
    private final JokeService jokeService;

    @Autowired
    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @PostMapping("/joke")
    public ResponseEntity GetJoke(@RequestBody GetJokeRequest getJokeRequest){
        try{
            return new ResponseEntity(jokeService.GetJoke(getJokeRequest), HttpStatus.OK);
        }catch(Exception ex){
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/addJoke")
    public ResponseEntity AddJoke(@RequestBody AddJokeRequest addJokeRequest){
        try{
            return new ResponseEntity(jokeService.AddJoke(addJokeRequest), HttpStatus.CREATED);
        }catch(Exception ex){
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}