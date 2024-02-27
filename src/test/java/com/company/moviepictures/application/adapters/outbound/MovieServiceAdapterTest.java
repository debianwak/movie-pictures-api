package com.company.moviepictures.application.adapters.outbound;

import com.company.moviepictures.application.domain.model.MoviePicture;
import com.company.moviepictures.application.domain.model.MoviePictureVO;
import com.company.moviepictures.application.domain.repository.MoviePictureRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class MovieServiceAdapterTest {

    @Autowired
    private MoviesServicePort moviesServicePort;

    @MockBean
    private MoviePictureRepositoryPort moviePictureRepositoryPort;

    @BeforeEach
    public void setUp() {
        // Reset mock before each test
        reset(moviePictureRepositoryPort);
    }

    @Test
    public void testGetAllMoviePicturesGroupedByReleaseYear() {
        // Mock data
        List<MoviePicture> moviePictures = Arrays.asList(
                new MoviePicture(1L, "Inception", "Sci-Fi", "url1", 10, 2022),
                new MoviePicture(2L, "The Shawshank Redemption", "Drama", "url2", 15, 2023));

        // Mock behavior of service port
        when(moviePictureRepositoryPort.findAll()).thenReturn(moviePictures);

        // Call the method to test
        List<MoviePictureVO> result = moviesServicePort.getAllMoviePicturesGroupedByReleaseYear();

        // Verify the result
        assertEquals(2, result.size());
        assertEquals("url1", result.get(0).getUrl());
        assertEquals(2022, result.get(0).getReleaseYear());
        assertEquals(10, result.get(0).getFavoritesCount());
        assertEquals("url2", result.get(1).getUrl());
        assertEquals(2023, result.get(1).getReleaseYear());
        assertEquals(15, result.get(1).getFavoritesCount());

        // Verify that the service port method was called
        verify(moviePictureRepositoryPort, times(1)).findAll();
    }

    @Test
    public void testGetMoviePicturesByReleaseYear() {
        // Mock data
        List<MoviePicture> moviePictures = Arrays.asList(
                new MoviePicture(1L, "Ichy the Killer", "Horror", "url1", 10, 2022),
                new MoviePicture(2L, "The Shawshank Redemption", "Drama", "url2", 15, 2022),
                new MoviePicture(3L, "Inception", "Sci-Fi", "url3", 20, 2024));


        // Mock behavior of repository port
        when(moviePictureRepositoryPort.findByReleaseYear(2022)).thenReturn(moviePictures
                .stream()
                .filter(v -> v.getReleaseYear() == 2022)
                .collect(Collectors.toList()));

        // Call the method to test
        List<MoviePictureVO> result = moviesServicePort.getMoviePicturesByReleaseYear(2022);

        // Verify the result
        assertEquals(2, result.size());
        assertEquals("url1", result.get(0).getUrl());
        assertEquals(2022, result.get(0).getReleaseYear());
        assertEquals(10, result.get(0).getFavoritesCount());
        assertEquals("url2", result.get(1).getUrl());
        assertEquals(2022, result.get(1).getReleaseYear());
        assertEquals(15, result.get(1).getFavoritesCount());

        // Verify that the repository port method was called
        verify(moviePictureRepositoryPort, times(1)).findByReleaseYear(2022);
    }

    @Test
    public void testVoteUpMoviePicture() {
        Long moviePictureId = 1L;
        MoviePicture moviePicture = new MoviePicture(moviePictureId, "Ichy the Killer", "Horror", "url1", 10, 2022);

        // Mock behavior of repository port
        when(moviePictureRepositoryPort.findById(moviePictureId)).thenReturn(Optional.of(moviePicture));

        // Call the method to test
        moviesServicePort.voteUpMoviePicture(moviePictureId);

        // Verify that the repository port method was called
        verify(moviePictureRepositoryPort, times(1)).findById(moviePictureId);

        // Verify that the movie picture was updated
        assertEquals(11, moviePicture.getFavoritesCount());
    }

    @Test
    public void testVoteDownMoviePicture() {
        Long moviePictureId = 1L;
        MoviePicture moviePicture = new MoviePicture(moviePictureId, "Ichy the Killer", "Horror", "url1", 10, 2022);

        // Mock behavior of repository port
        when(moviePictureRepositoryPort.findById(moviePictureId)).thenReturn(Optional.of(moviePicture));

        // Call the method to test
        moviesServicePort.voteDownMoviePicture(moviePictureId);

        // Verify that the repository port method was called
        verify(moviePictureRepositoryPort, times(1)).findById(moviePictureId);

        // Verify that the movie picture was updated
        assertEquals(9, moviePicture.getFavoritesCount());
    }

    @Test
    public void testGetMoviePictureDetails() {
        Long moviePictureId = 1L;
        MoviePicture moviePicture = new MoviePicture(moviePictureId, "Ichy the Killer", "Horror", "url1", 10, 2022);

        // Mock behavior of repository port
        when(moviePictureRepositoryPort.findById(moviePictureId)).thenReturn(Optional.of(moviePicture));

        // Call the method to test
        MoviePictureVO result = moviesServicePort.getMoviePictureDetails(moviePictureId);

        // Verify the result
        assertEquals("url1", result.getUrl());
        assertEquals(2022, result.getReleaseYear());
        assertEquals(10, result.getFavoritesCount());

        // Verify that the repository port method was called
        verify(moviePictureRepositoryPort, times(1)).findById(moviePictureId);
    }
}
