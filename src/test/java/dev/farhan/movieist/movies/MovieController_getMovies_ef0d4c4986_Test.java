package dev.farhan.movieist.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.ArrayList;

public class MovieController_getMovies_ef0d4c4986_Test {
    
    private MovieService service;

    @Test
    public void testGetMovies() {
        // Mocking the MovieService
        MovieService mockService = mock(MovieService.class);

        // Mocking the response of findAllMovies method
        when(mockService.findAllMovies()).thenReturn(new ArrayList<Movie>());

        // Creating an instance of MovieController and setting the mocked service
        MovieController movieController = new MovieController();
        movieController.service = mockService;

        // Calling the method we want to test
        ResponseEntity<List<Movie>> response = movieController.getMovies();

        // Checking if the response status is OK
        assertEquals(HttpStatus.OK, response.getStatusCode());

        // Checking if the response body is not null
        assertNotNull(response.getBody());

        // Checking if the response body is an instance of List
        assertTrue(response.getBody() instanceof List);
    }

    @Test
    public void testGetMoviesFailure() {
        // Mocking the MovieService
        MovieService mockService = mock(MovieService.class);

        // Mocking the response of findAllMovies method to return null
        when(mockService.findAllMovies()).thenReturn(null);

        // Creating an instance of MovieController and setting the mocked service
        MovieController movieController = new MovieController();
        movieController.service = mockService;

        // Calling the method we want to test
        ResponseEntity<List<Movie>> response = movieController.getMovies();

        // Checking if the response status is OK
        assertEquals(HttpStatus.OK, response.getStatusCode());

        // Checking if the response body is null
        assertNull(response.getBody());
    }
}
