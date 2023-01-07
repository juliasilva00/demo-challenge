package com.bees.operations.demo.controller;


import com.bees.operations.demo.model.Movie;
import com.bees.operations.demo.repository.MovieRepository;
import com.bees.operations.demo.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/mock")
public class MovieController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping
    public List<Movie> getMovie(){
        return movieService.findAll();
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        LOGGER.info("GET /id mock API");
        return new ResponseEntity(movieService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Movie> createMock(@RequestBody Movie movie ){
        movie.setRate(movieService.getRandomNumber());
        return new ResponseEntity(movieService.createMovie(movie), HttpStatus.CREATED) ;
    }
}


