package com.fawry.movie.controller;


import com.fawry.movie.model.Movie;
import com.fawry.movie.service.MovieService;
import com.fawry.movie.service.MovieServiceImpl;
import lombok.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/movies")
public class MovieController {

    private final MovieServiceImpl movieServiceImpl;

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieServiceImpl.getAllMovies();
    }

    @GetMapping("/{imdbID}")
    public Movie getMovieByImdbID(@PathVariable String imdbID) {
        return movieServiceImpl.getMovieByImdbID(imdbID);
    }

    @GetMapping("/{title}/{year}")
    public Movie getMovieByTitleAndYear(@PathVariable String title , @PathVariable String year) {
        return movieServiceImpl.getMovieByTitleAndYear(title, year);
    }

    @PostMapping("/{imdbID}")
    public Movie addMovieByImdbID(@PathVariable String imdbID) {
        return movieServiceImpl.addMovieByImdbID(imdbID);
    }

    @PostMapping("/{title}/{year}")
    public Movie addMovieByTitleAndYear(@PathVariable String title , @PathVariable String year) {
        return movieServiceImpl.addMovieByTitleAndYear(title, year);
    }

    @DeleteMapping("/{imdbID}")
    public void deleteMovie(@PathVariable String imdbID) {
        movieServiceImpl.deleteMovie(imdbID);
    }
}
