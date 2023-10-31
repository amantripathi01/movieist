package dev.farhan.movieist.movies;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class MovieService_findMovieByImdbId_40fa508bae_Test {

    @InjectMocks
    private MovieService movieService;

    @Mock
    private MovieRepository repository;

    @Test
    public void testFindMovieByImdbId_ValidId() {
        String imdbId = "tt0111161"; // TODO: replace this with a valid IMDB Id

        Optional<Movie> movie = Optional.ofNullable(null);

        when(repository.findMovieByImdbId(imdbId)).thenReturn(movie);

        Optional<Movie> result = movieService.findMovieByImdbId(imdbId);

        verify(repository, times(1)).findMovieByImdbId(imdbId);
        assertThat(result).isNotEmpty();
        assertThat(result.get().getImdbId()).isEqualTo(imdbId);
    }

    @Test
    public void testFindMovieByImdbId_InvalidId() {
        String imdbId = "invalidId"; // TODO: replace this with an invalid IMDB Id

        when(repository.findMovieByImdbId(imdbId)).thenReturn(Optional.empty());

        Optional<Movie> result = movieService.findMovieByImdbId(imdbId);

        verify(repository, times(1)).findMovieByImdbId(imdbId);
        assertThat(result).isEmpty();
    }
}
