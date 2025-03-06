package com.fawry.movie.service;

import com.fawry.movie.model.Movie;
import com.fawry.movie.utils.OMDBSearchResponse;
import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies();

    Movie getMovieByImdbID(String imdbID);

    Movie getMovieByTitleAndYear(String title , String year);

    OMDBSearchResponse searchMovieByTitle_OMDB(String title);

    Movie getMovieByImdbID_OMDB(String imdbID);

    Movie getMovieByTitleAndYear_OMDB(String title , String year);

    Movie addMovieByImdbID(String imdbID);

    Movie addMovieByTitleAndYear(String title, String year);

    void deleteMovie(String imdbID);
}
