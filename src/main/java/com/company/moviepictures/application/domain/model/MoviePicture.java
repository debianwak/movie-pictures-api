package com.company.moviepictures.application.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "movie_picture")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MoviePicture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Genre is required")
    private String genre;

    private String url;
    private int favoritesCount;
    private int releaseYear;
}
