package com.jokeapi.myjokeapi.joke;

import com.jokeapi.myjokeapi.joke.exceptions.NoJokeFoundException;
import com.jokeapi.myjokeapi.joke.request.AddJokeRequest;
import com.jokeapi.myjokeapi.joke.request.GetJokeRequest;
import com.jokeapi.myjokeapi.languages.exceptions.NoLanguageFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class JokeController {
    private static final Logger LOGGER = LogManager.getLogger(JokeController.class);

    private final JokeService jokeService;

    @Autowired
    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @PostMapping("/joke")
    public ResponseEntity GetJoke(@RequestBody GetJokeRequest getJokeRequest){
        try{
            return new ResponseEntity(jokeService.GetJoke(getJokeRequest), HttpStatus.OK);
        } catch (NoLanguageFoundException noLanguage) {
            LOGGER.warn("TRY TO GET JOKE WITH NON EXISTED LANGUAGE");
            return new ResponseEntity("Can not find any languages in database by presented id:" + getJokeRequest.language, HttpStatus.NOT_FOUND);
        } catch (NoJokeFoundException noJoke) {
            LOGGER.warn("TRY TO GET JOKE WITH NON EXISTED PARAMETERS");
            return new ResponseEntity("Can not find any jokes by presented parameters", HttpStatus.NOT_FOUND);
        }catch(Exception ex){
            LOGGER.error("ERROR WHILE GETTING JOKE: \n" + ex.getMessage());
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/addJoke")
    public ResponseEntity AddJoke(@RequestBody AddJokeRequest addJokeRequest){
        try{
            return new ResponseEntity(jokeService.AddJoke(addJokeRequest), HttpStatus.CREATED);
        } catch (NoLanguageFoundException noLanguage) {
            LOGGER.warn("TRY TO GET JOKE WITH NON EXISTED LANGUAGE");
            return new ResponseEntity("Can not find any languages in database by presented id:" + addJokeRequest.languageId, HttpStatus.NOT_FOUND);
        } catch(Exception ex) {
            LOGGER.error("ERROR WHILE ADD JOKE: \n" + ex.getMessage());
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}