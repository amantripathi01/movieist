package dev.farhan.movieist.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "movies")
public class Movie {

    @Id
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> backdrops;
    private List<String> genres;
    private List<Review> reviews;
}

class Movie_Movie_d09d4293c0_Test {

    @Test
    public void testMovieConstructor() {
        String imdbId = "tt0111161";
        String title = "The Shawshank Redemption";
        String releaseDate = "1994-09-22";
        String trailerLink = "https://youtu.be/6hB3S9bIaco";
        String poster = "https://image.tmdb.org/t/p/original/q6y0Go1tsGEsmtFryDOJo3dEmqu.jpg";
        List<String> backdrops = Arrays.asList("https://image.tmdb.org/t/p/original/avedvodAZUcwqevBfm8p4G2NziQ.jpg");
        List<String> genres = Arrays.asList("Drama");

        Movie movie = new Movie();
        movie.setImdbId(imdbId);
        movie.setTitle(title);
        movie.setReleaseDate(releaseDate);
        movie.setTrailerLink(trailerLink);
        movie.setPoster(poster);
        movie.setBackdrops(backdrops);
        movie.setGenres(genres);

        assertEquals(imdbId, movie.getImdbId());
        assertEquals(title, movie.getTitle());
        assertEquals(releaseDate, movie.getReleaseDate());
        assertEquals(trailerLink, movie.getTrailerLink());
        assertEquals(poster, movie.getPoster());
        assertEquals(backdrops, movie.getBackdrops());
        assertEquals(genres, movie.getGenres());
    }
    
    @Test
    public void testMovieConstructor_NullValues() {
        String imdbId = null;
        String title = null;
        String releaseDate = null;
        String trailerLink = null;
        String poster = null;
        List<String> backdrops = null;
        List<String> genres = null;

        Movie movie = new Movie();
        movie.setImdbId(imdbId);
        movie.setTitle(title);
        movie.setReleaseDate(releaseDate);
        movie.setTrailerLink(trailerLink);
        movie.setPoster(poster);
        movie.setBackdrops(backdrops);
        movie.setGenres(genres);

        assertNull(movie.getImdbId());
        assertNull(movie.getTitle());
        assertNull(movie.getReleaseDate());
        assertNull(movie.getTrailerLink());
        assertNull(movie.getPoster());
        assertNull(movie.getBackdrops());
        assertNull(movie.getGenres());
    }
}
