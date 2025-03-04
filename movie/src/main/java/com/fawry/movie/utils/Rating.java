package com.fawry.movie.utils;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embeddable;
import lombok.*;

@Data
@Embeddable
public class Rating {
    @JsonProperty("Source")
    private String source;

    @JsonProperty("Value")
    private String value;
}
