package com.fawry.movie.utils;

import jakarta.persistence.Embeddable;
import lombok.*;

@Data
@Embeddable
public class Rating {
    private String source;
    private String value;
}
