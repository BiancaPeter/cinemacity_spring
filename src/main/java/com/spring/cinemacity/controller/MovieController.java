package com.spring.cinemacity.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.spring.cinemacity.DTO.AddMovieDTO;
import com.spring.cinemacity.model.Movie;
import com.spring.cinemacity.model.Projection;
import com.spring.cinemacity.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {
    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/add")
    public Movie addMovie(@RequestBody AddMovieDTO addMovieDTO) throws JsonProcessingException {
        return movieService.addMovie(addMovieDTO);
    }

    @GetMapping("/projections-available/{movieId}")
    public List<Projection> getAllProjectionsAvailable(@PathVariable Long movieId) {
        return movieService.getAllProjectionsAvailable(movieId);
    }
}
