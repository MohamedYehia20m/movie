package com.fawry.movie.utils;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class OMDBSearchResponse {
    @JsonProperty("Search")
    private List<Search> search;

    @JsonProperty("totalResults")
    private String totalResults;

    @JsonProperty("Response")
    private String response;
}