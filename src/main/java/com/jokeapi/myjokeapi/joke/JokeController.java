package com.jokeapi.myjokeapi.joke;

import com.jokeapi.myjokeapi.joke.request.AddJokeRequest;
import com.jokeapi.myjokeapi.joke.request.GetJokeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class JokeController {
    private final JokeService jokeService;

    @Autowired
    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @PostMapping("/joke")
    public ResponseEntity GetJoke(@RequestBody GetJokeRequest getJokeRequest){
        try{
            return ResponseEntity.ok(jokeService.GetJoke(getJokeRequest));
        }catch(Exception e){
            return ResponseEntity.badRequest().body("Cant find jokes with that params");
        }
    }

    @PostMapping("/addJoke")
    public ResponseEntity AddJoke(@RequestBody AddJokeRequest addJokeRequest){
        try{
            return ResponseEntity.ok(jokeService.AddJoke(addJokeRequest));
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}