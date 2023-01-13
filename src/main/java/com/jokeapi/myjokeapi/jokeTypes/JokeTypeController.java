package com.jokeapi.myjokeapi.jokeTypes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
public class JokeTypeController {
    private final JokeTypeService jokeTypeService;

    @Autowired
    public JokeTypeController(JokeTypeService jokeTypeService){
        this.jokeTypeService = jokeTypeService;
    }

    @GetMapping("/jokeTypes")
    @ResponseBody
    public ResponseEntity GetJokeTypeById() {
        try{
            return ResponseEntity.ok(jokeTypeService.GetAllJokeType());
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
