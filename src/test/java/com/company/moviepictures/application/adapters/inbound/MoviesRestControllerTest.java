package com.company.moviepictures.application.adapters.inbound;

import com.company.moviepictures.application.adapters.outbound.MoviesServicePort;
import com.company.moviepictures.application.domain.model.MoviePictureVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class MoviesRestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MoviesServicePort moviesServicePort;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllmoviePicturesGroupedByReleaseYear() throws Exception {
        // Mocking the behavior of moviesServicePort.getAllmoviePicturesGroupedByReleaseYear()
        when(moviesServicePort.getAllMoviePicturesGroupedByReleaseYear()).thenReturn(Arrays.asList(
                new MoviePictureVO(1L, "Ichy the Killer", "Horror", "https://example.com/movie1.jpg", 100, 2020),
                new MoviePictureVO(2L, "The Godfather", "Crime", "https://example.com/movie2.jpg", 200, 2021)
        ));

        mockMvc.perform(get("/movies"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].url").value("https://example.com/movie1.jpg"))
                .andExpect(jsonPath("$[0].favoritesCount").value(100))
                .andExpect(jsonPath("$[0].releaseYear").value(2020))
                .andExpect(jsonPath("$[0].name").value("Ichy the Killer"))
                .andExpect(jsonPath("$[0].genre").value("Horror"))
                .andExpect(jsonPath("$[1].url").value("https://example.com/movie2.jpg"))
                .andExpect(jsonPath("$[1].favoritesCount").value(200))
                .andExpect(jsonPath("$[1].releaseYear").value(2021))
                .andExpect(jsonPath("$[1].name").value("The Godfather"))
                .andExpect(jsonPath("$[1].genre").value("Crime"));

        verify(moviesServicePort, times(1)).getAllMoviePicturesGroupedByReleaseYear();
    }

    @Test
    public void testGetmoviePicturesByReleaseYear() throws Exception {
        int releaseYear = 2021;

        // Mocking the behavior of moviesServicePort.getmoviePicturesByReleaseYear()
        when(moviesServicePort.getMoviePicturesByReleaseYear(releaseYear)).thenReturn(Arrays.asList(
                new MoviePictureVO(1L, "Ichy the Killer", "Horror", "https://example.com/movie1.jpg", 100, 2021),
                new MoviePictureVO(2L, "The Godfather", "Crime", "https://example.com/movie2.jpg", 200, 2021)
        ));

        mockMvc.perform(get("/movies").param("releaseYear", String.valueOf(releaseYear)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].url").value("https://example.com/movie1.jpg"))
                .andExpect(jsonPath("$[0].favoritesCount").value(100))
                .andExpect(jsonPath("$[0].releaseYear").value(2021))
                .andExpect(jsonPath("$[0].name").value("Ichy the Killer"))
                .andExpect(jsonPath("$[0].genre").value("Horror"))
                .andExpect(jsonPath("$[1].url").value("https://example.com/movie2.jpg"))
                .andExpect(jsonPath("$[1].favoritesCount").value(200))
                .andExpect(jsonPath("$[1].releaseYear").value(2021))
                .andExpect(jsonPath("$[1].name").value("The Godfather"))
                .andExpect(jsonPath("$[1].genre").value("Crime"));

        verify(moviesServicePort, times(1)).getMoviePicturesByReleaseYear(releaseYear);
    }

    @Test
    public void testVoteUpMovieImage() throws Exception {
        Long movieId = 1L;

        mockMvc.perform(put("/movies/{movieId}/vote-up", movieId))
                .andExpect(status().isOk());

        verify(moviesServicePort, times(1)).voteUpMoviePicture(movieId);
    }

    @Test
    public void testVoteDownMovieImage() throws Exception {
        Long movieId = 1L;

        mockMvc.perform(put("/movies/{movieId}/vote-down", movieId))
                .andExpect(status().isOk());

        verify(moviesServicePort, times(1)).voteDownMoviePicture(movieId);
    }

    @Test
    public void testGetMovieImageDetails() throws Exception {
        Long movieId = 1L;

        // Mocking the behavior of moviesServicePort.getMovieImageDetails()
        when(moviesServicePort.getMoviePictureDetails(movieId)).thenReturn(
                new MoviePictureVO(1L, "Ichy the Killer", "Horror", "https://example.com/movie1.jpg", 100, 2021)
        );

        mockMvc.perform(get("/movies/{movieId}", movieId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.url").value("https://example.com/movie1.jpg"))
                .andExpect(jsonPath("$.favoritesCount").value(100))
                .andExpect(jsonPath("$.releaseYear").value(2021))
                .andExpect(jsonPath("$.name").value("Ichy the Killer"))
                .andExpect(jsonPath("$.genre").value("Horror"));

        verify(moviesServicePort, times(1)).getMoviePictureDetails(movieId);
    }
}
