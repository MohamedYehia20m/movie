package com.fawry.movie.service;

import com.fawry.movie.model.Movie;
import com.fawry.movie.repository.MovieRepository;
import lombok.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieByImdbID(String imdbID) {
        return movieRepository.findByImdbID(imdbID);
    }

    public Movie getMovieByTitleAndYear(String title , String year) {
        return movieRepository.findByTitleAndYear(title , year);
    }

    public Movie addMovieByImdbID(String imdbID) {
        String apikey = "d6ee1b2f";
        String url = "http://www.omdbapi.com/?apikey=" + apikey + "&i=" + imdbID + "&plot=full";

        // call the api and get the movie data
        RestTemplate restTemplate = new RestTemplate();
        Movie movie = restTemplate.getForObject(url, Movie.class);

        if (movie != null && "True".equalsIgnoreCase(movie.getResponse())) {
            return movieRepository.save(movie);
        }
        else {
            throw new IllegalArgumentException("Invalid movie data");
        }

    }

    public Movie addMovieByTitleAndYear(String title, String year) {
        String apikey = "d6ee1b2f";
        String url = "http://www.omdbapi.com/?apikey=" + apikey + "&t=" + title + "&y=" + year+"&plot=full";

        // call the api and get the movie data
        RestTemplate restTemplate = new RestTemplate();
        Movie movie = restTemplate.getForObject(url, Movie.class);

        if (movie != null && "True".equalsIgnoreCase(movie.getResponse())) {
            return movieRepository.save(movie);
        }
        else {
            throw new IllegalArgumentException("Invalid movie data");
        }

    }

    public void deleteMovie(String imdbID) {
        movieRepository.deleteById(imdbID);
    }
}
