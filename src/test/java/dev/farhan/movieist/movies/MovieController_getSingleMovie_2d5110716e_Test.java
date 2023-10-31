package dev.farhan.movieist.movies;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

@SpringBootTest
public class MovieController_getSingleMovie_2d5110716e_Test {

    @InjectMocks
    private MovieController movieController;

    @MockBean
    private MovieService movieService;

    @Test
    public void testGetSingleMovie_success() {
        Movie movie = new Movie();
        when(movieService.findMovieByImdbId("tt1234567")).thenReturn(Optional.of(movie));

        ResponseEntity<Optional<Movie>> response = movieController.getSingleMovie("tt1234567");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("tt1234567", response.getBody().get().getImdbId());
    }

    @Test
    public void testGetSingleMovie_noMovieFound() {
        when(movieService.findMovieByImdbId("tt1234567")).thenReturn(Optional.empty());

        ResponseEntity<Optional<Movie>> response = movieController.getSingleMovie("tt1234567");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(Optional.empty(), response.getBody());
    }
}
