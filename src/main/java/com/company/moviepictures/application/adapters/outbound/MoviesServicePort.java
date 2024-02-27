package com.company.moviepictures.application.adapters.outbound;

import com.company.moviepictures.application.domain.model.MoviePictureVO;

import java.util.List;

public interface MoviesServicePort {
    List<MoviePictureVO> getAllMoviePicturesGroupedByReleaseYear();

    List<MoviePictureVO> getMoviePicturesByReleaseYear(int releaseYear);

    void voteUpMoviePicture(Long MoviePictureId);

    void voteDownMoviePicture(Long MoviePictureId);

    MoviePictureVO getMoviePictureDetails(Long MoviePictureId);
}
