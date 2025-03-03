package com.fawry.movie.repository;

import com.fawry.movie.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, String> {
    Movie findByImdbID(String imdbID);
    Movie findByTitleAndYear(String title, String year);
}
