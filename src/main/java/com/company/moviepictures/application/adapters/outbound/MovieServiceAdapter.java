package com.company.moviepictures.application.adapters.outbound;

import com.company.moviepictures.application.domain.model.MoviePicture;
import com.company.moviepictures.application.domain.model.MoviePictureVO;
import com.company.moviepictures.application.domain.repository.MoviePictureRepositoryPort;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceAdapter implements MoviesServicePort {
    @Autowired
    private MoviePictureRepositoryPort moviePictureRepositoryPort;

    @Override
    public List<MoviePictureVO> getAllMoviePicturesGroupedByReleaseYear() {
        List<MoviePicture> moviePictures = moviePictureRepositoryPort.findAll();
        System.out.println("Number of movie pictures found: " + moviePictures.size());
        return mapToMoviePictureVOList(moviePictures);
    }

    @Override
    public List<MoviePictureVO> getMoviePicturesByReleaseYear(int releaseYear) {
        List<MoviePicture> moviePictures = moviePictureRepositoryPort.findByReleaseYear(releaseYear);
        return mapToMoviePictureVOList(moviePictures);
    }

    @Override
    public void voteUpMoviePicture(Long moviePictureId) {
        MoviePicture moviePicture = moviePictureRepositoryPort.findById(moviePictureId)
                .orElseThrow(() -> new EntityNotFoundException("Movie picture not found with id: " + moviePictureId));
        moviePicture.setFavoritesCount(moviePicture.getFavoritesCount() + 1);
        moviePictureRepositoryPort.save(moviePicture);
    }

    @Override
    public void voteDownMoviePicture(Long moviePictureId) {
        MoviePicture moviePicture = moviePictureRepositoryPort.findById(moviePictureId)
                .orElseThrow(() -> new EntityNotFoundException("Movie picture not found with id: " + moviePictureId));
        moviePicture.setFavoritesCount(moviePicture.getFavoritesCount() - 1);
        moviePictureRepositoryPort.save(moviePicture);
    }

    @Override
    public MoviePictureVO getMoviePictureDetails(Long moviePictureId) {
        MoviePicture moviePicture = moviePictureRepositoryPort.findById(moviePictureId)
                .orElseThrow(() -> new EntityNotFoundException("Movie picture not found with id: " + moviePictureId));
        return mapToMoviePictureVO(moviePicture);
    }

    // Utility method to convert MoviePicture entity to MoviePictureVO
    private MoviePictureVO mapToMoviePictureVO(MoviePicture moviePicture) {
        MoviePictureVO moviePictureVO = new MoviePictureVO();
        moviePictureVO.setId(moviePicture.getId());
        moviePictureVO.setUrl(moviePicture.getUrl());
        moviePictureVO.setFavoritesCount(moviePicture.getFavoritesCount());
        moviePictureVO.setReleaseYear(moviePicture.getReleaseYear());
        moviePictureVO.setName(moviePicture.getName());
        moviePictureVO.setGenre(moviePicture.getGenre());

        return moviePictureVO;
    }

    // Utility method to convert List<MoviePicture> to List<MoviePictureVO>
    private List<MoviePictureVO> mapToMoviePictureVOList(List<MoviePicture> moviePictures) {
        return moviePictures.stream()
                .map(this::mapToMoviePictureVO)
                .collect(Collectors.toList());
    }
}
