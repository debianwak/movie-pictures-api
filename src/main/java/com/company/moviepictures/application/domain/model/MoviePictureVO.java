package com.company.moviepictures.application.domain.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MoviePictureVO {
    private Long Id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Genre is required")
    private String genre;

    @NotBlank(message = "URL is required")
    private String url;

    @NotNull(message = "Favorites count is required")
    private int favoritesCount;

    @NotNull(message = "Release year is required")
    private int releaseYear;
}
