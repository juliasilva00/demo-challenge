package com.bees.operations.demo.service;


import com.bees.operations.demo.model.Movie;
import com.bees.operations.demo.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Transactional //declara que esse metodo deve ser executado dentro de uma transação
    public Movie createMovie(Movie movie){
        return movieRepository.save(movie);
    }

    public long getRandomNumber() {
        Random random = new Random();
        return random.nextInt(1000);
    }

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    public Optional<Movie> findById(Long id) {
        return movieRepository.findById(id);
    }
}
