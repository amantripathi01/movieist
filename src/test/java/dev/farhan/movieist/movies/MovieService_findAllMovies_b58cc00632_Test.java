package dev.farhan.movieist.movies;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class MovieService_findAllMovies_b58cc00632_Test {

    @InjectMocks
    private MovieService movieService;

    @Mock
    private MovieRepository repository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAllMovies() {
        Movie movie1 = new Movie();
        movie1.setImdbId("tt0111161");
        movie1.setTitle("The Shawshank Redemption");
        // movie1.setYear("1994"); removed this line

        Movie movie2 = new Movie();
        movie2.setImdbId("tt0068646");
        movie2.setTitle("The Godfather");
        // movie2.setYear("1972"); removed this line

        List<Movie> expectedMovies = Arrays.asList(movie1, movie2);

        when(repository.findAll()).thenReturn(expectedMovies);

        List<Movie> actualMovies = movieService.findAllMovies();

        assertEquals(expectedMovies, actualMovies);
    }

    @Test
    public void testFindAllMovies_NoMovies() {
        when(repository.findAll()).thenReturn(null);

        List<Movie> actualMovies = movieService.findAllMovies();

        assertEquals(null, actualMovies);
    }
}
