package dev.farhan.movieist.movies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Optional;
import static org.mockito.Mockito.when;

public class MovieController_getSingleMovie_2d5110716e_Test {

    private MovieService service = Mockito.mock(MovieService.class);
    private MovieController controller = new MovieController(service);

    @Test
    public void testGetSingleMovie_Success() {
        Movie movie = new Movie();
        movie.setImdbId("tt0111161");
        when(service.findMovieByImdbId("tt0111161")).thenReturn(Optional.of(movie));

        ResponseEntity<Optional<Movie>> response = controller.getSingleMovie("tt0111161");

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertTrue(response.getBody().isPresent());
        Assertions.assertEquals("tt0111161", response.getBody().get().getImdbId());
    }

    @Test
    public void testGetSingleMovie_NotFound() {
        when(service.findMovieByImdbId("tt0111161")).thenReturn(Optional.empty());

        ResponseEntity<Optional<Movie>> response = controller.getSingleMovie("tt0111161");

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertFalse(response.getBody().isPresent());
    }
}
