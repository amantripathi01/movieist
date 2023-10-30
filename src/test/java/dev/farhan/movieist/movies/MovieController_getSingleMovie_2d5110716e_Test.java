package dev.farhan.movieist.movies;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class MovieController_getSingleMovie_2d5110716e_Test {

    @InjectMocks
    private MovieController movieController;

    @Mock
    private MovieService movieService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetSingleMovie_Success() {
        String imdbId = "tt0111161";
        Movie movie = new Movie();
        // movie.setImdbId(imdbId); // removed this line because it caused a compilation error
        when(movieService.findMovieByImdbId(imdbId)).thenReturn(Optional.of(movie));

        ResponseEntity<Optional<Movie>> responseEntity = movieController.getSingleMovie(imdbId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(Optional.of(movie), responseEntity.getBody());
    }

    @Test
    public void testGetSingleMovie_NotFound() {
        String imdbId = "tt0111161";
        when(movieService.findMovieByImdbId(imdbId)).thenReturn(Optional.empty());

        ResponseEntity<Optional<Movie>> responseEntity = movieController.getSingleMovie(imdbId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(Optional.empty(), responseEntity.getBody());
    }

}
