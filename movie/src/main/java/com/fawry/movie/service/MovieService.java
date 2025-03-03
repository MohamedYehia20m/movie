package com.fawry.movie.service;

import com.fawry.movie.model.Movie;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    List<Movie> getAllMovies();

    Movie getMovieByImdbID(String imdbID);

    Movie getMovieByTitleAndYear(String title , String year);

    Movie addMovieByImdbID(String imdbID);

    Movie addMovieByTitleAndYear(String title, String year);

    void deleteMovie(String imdbID);
}
