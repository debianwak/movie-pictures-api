package com.company.moviepictures.application.adapters.inbound;


import com.company.moviepictures.application.adapters.outbound.MoviesServicePort;
import com.company.moviepictures.application.domain.model.MoviePictureVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MoviesRestController {

    @Autowired
    private MoviesServicePort moviesServicePort;

    @GetMapping()
    public ResponseEntity<List<MoviePictureVO>> getAllMoviesReleaseYear(
            @RequestParam(value = "releaseYear", required = false) Integer releaseYear) {
        if (releaseYear == null) {
            List<MoviePictureVO> moviePictures = moviesServicePort.getAllMoviePicturesGroupedByReleaseYear();
            return new ResponseEntity<>(moviePictures, HttpStatus.OK);
        }

        List<MoviePictureVO> moviePictures = moviesServicePort.getMoviePicturesByReleaseYear(releaseYear);
        return new ResponseEntity<>(moviePictures, HttpStatus.OK);
    }

    @PostMapping("/vote-up/{movieId}")
    public ResponseEntity<?> voteUpMovieImage(@PathVariable("movieId") Long movieId) {
        moviesServicePort.voteUpMoviePicture(movieId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/vote-down/{movieId}")
    public ResponseEntity<?> voteDownMovieImage(@PathVariable("movieId") Long movieId) {
        moviesServicePort.voteDownMoviePicture(movieId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<MoviePictureVO> getMovieImageDetails(@PathVariable Long movieId) {
        MoviePictureVO movieImage = moviesServicePort.getMoviePictureDetails(movieId);
        return new ResponseEntity<>(movieImage, HttpStatus.OK);
    }
}
