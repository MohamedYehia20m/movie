package com.fawry.movie.service;

import com.fawry.movie.model.Movie;
import com.fawry.movie.repository.MovieRepository;
import com.fawry.movie.utils.OMDBSearchResponse;
import lombok.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;
    private static final Logger logger = LoggerFactory.getLogger(MovieServiceImpl.class);

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieByImdbID(String imdbID) {
        return movieRepository.findByImdbID(imdbID);
    }

    public Movie getMovieByTitleAndYear(String title , String year) {
        return movieRepository.findByTitleAndYear(title , year);
    }

    public OMDBSearchResponse searchMovieByTitle_OMDB(String title) {
        String apikey = "d6ee1b2f";
        String url = "http://www.omdbapi.com/?apikey=" + apikey + "&s=" + title + "&plot=full";

        // call the api and get the search data list
        RestTemplate restTemplate = new RestTemplate();
        OMDBSearchResponse response = restTemplate.getForObject(url, OMDBSearchResponse.class);

        if (response != null && "True".equalsIgnoreCase(response.getResponse())) {
            return response;
        } else {
            return new OMDBSearchResponse();
        }
    }

    public Movie addMovieByImdbID(String imdbID) {
        String apikey = "d6ee1b2f";
        String url = "http://www.omdbapi.com/?apikey=" + apikey + "&i=" + imdbID + "&plot=full";

        // call the api and get the movie data
        RestTemplate restTemplate = new RestTemplate();
        Movie movie = restTemplate.getForObject(url, Movie.class);

        // Log the response
        logger.debug("OMDB API response: {}", movie);

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
