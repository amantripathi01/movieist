package dev.farhan.movieist.movies;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class MovieController_getMovies_ef0d4c4986_Test {

    @InjectMocks
    MovieController movieController;

    @Mock
    MovieService service;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetMovies() {
        Movie movie1 = new Movie();
        Movie movie2 = new Movie();
        List<Movie> movies = Arrays.asList(movie1, movie2);

        when(service.findAllMovies()).thenReturn(movies);
        ResponseEntity<List<Movie>> responseEntity = movieController.getMovies();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(movies, responseEntity.getBody());
    }

    @Test
    public void testGetMovies_NoMovies() {
        when(service.findAllMovies()).thenReturn(Arrays.asList());
        ResponseEntity<List<Movie>> responseEntity = movieController.getMovies();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(0, responseEntity.getBody().size());
    }
} 
