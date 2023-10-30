package dev.farhan.movieist.movies;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class MovieService_findAllMovies_b58cc00632_Test {

    @Mock
    private MovieRepository repository;

    @InjectMocks
    private MovieService movieService;

    private Movie movie1;
    private Movie movie2;

    @BeforeEach
    void setUp() {
        movie1 = new Movie("tt0111161", "The Shawshank Redemption");
        movie2 = new Movie("tt0068646", "The Godfather");

        when(repository.findAll()).thenReturn(Arrays.asList(movie1, movie2));
    }

    @Test
    public void testFindAllMovies() {
        List<Movie> movies = movieService.findAllMovies();
        assertEquals(2, movies.size());
        assertEquals(movie1, movies.get(0));
        assertEquals(movie2, movies.get(1));
    }

    @Test
    public void testFindAllMovies_empty() {
        when(repository.findAll()).thenReturn(Arrays.asList());
        List<Movie> movies = movieService.findAllMovies();
        assertEquals(0, movies.size());
    }
}
