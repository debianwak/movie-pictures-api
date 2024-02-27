package com.company.moviepictures.application.domain.repository;

import com.company.moviepictures.application.domain.model.MoviePicture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoviePictureRepositoryPort extends JpaRepository<MoviePicture, Long> {
    List<MoviePicture> findByReleaseYear(int releaseYear);
}
