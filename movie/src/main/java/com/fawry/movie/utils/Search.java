package com.fawry.movie.utils;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
public class Search {

    @JsonProperty("Title")
    private String title;

    @JsonProperty("Year")
    private String year;

    @JsonProperty("imdbID")
    private String imdbID;

    @JsonProperty("Type")
    private String type;

    @JsonProperty("Poster")
    private String poster;


}
