package dev.farhan.movieist.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository repository;

    public List<Movie> findAllMovies() {
        return repository.findAll();
    }

    public Optional<Movie> findMovieByImdbId(String imdbId) {
        return repository.findMovieByImdbId(imdbId);
    }
}

package dev.farhan.movieist.movies;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class MovieService_findAllMovies_b58cc00632_Test {
    
    @Autowired
    private MovieService movieService;
    
    @MockBean
    private MovieRepository movieRepository;

    @Test
    public void testFindAllMovies() {
        List<Movie> mockMovies = new ArrayList<>();
        mockMovies.add(new Movie("tt0111161", "The Shawshank Redemption", "1994", "9.3"));
        mockMovies.add(new Movie("tt0068646", "The Godfather", "1972", "9.2"));

        when(movieRepository.findAll()).thenReturn(mockMovies);

        List<Movie> movies = movieService.findAllMovies();
        assertNotNull(movies);
        assertTrue(movies.size() > 0);
    }

    @Test
    public void testFindAllMovies_NoMovies() {
        List<Movie> mockMovies = new ArrayList<>();
        when(movieRepository.findAll()).thenReturn(mockMovies);

        List<Movie> movies = movieService.findAllMovies();
        assertNotNull(movies);
        assertTrue(movies.isEmpty());
    }
}
