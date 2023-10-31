package dev.farhan.movieist.movies;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class MovieController_getMovies_ef0d4c4986_Test {

    @Mock
    private MovieService service;

    private MovieController movieController;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        movieController = new MovieController();
    }

    @Test
    public void testGetMovies_success() {
        Movie movie1 = new Movie();
        Movie movie2 = new Movie();
        List<Movie> movies = Arrays.asList(movie1, movie2);

        when(service.findAllMovies()).thenReturn(movies);

        ResponseEntity<List<Movie>> response = movieController.getMovies();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(movies, response.getBody());
    }

    @Test
    public void testGetMovies_noMoviesFound() {
        when(service.findAllMovies()).thenReturn(null);

        ResponseEntity<List<Movie>> response = movieController.getMovies();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(null, response.getBody());
    }
}
