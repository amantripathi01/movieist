package dev.farhan.movieist.movies;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "movies")
public class Movie_Movie_d09d4293c0_Test {

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

    @Test
    public void testMovieConstructor() {
        List<String> backdrops = new ArrayList<>();
        backdrops.add("backdrop1");
        backdrops.add("backdrop2");

        List<String> genres = new ArrayList<>();
        genres.add("genre1");
        genres.add("genre2");

        Movie movie = new Movie("tt1234567", "Test Title", "2022-01-01", "trailerLink", "poster", backdrops, genres);

        assertEquals("tt1234567", movie.getImdbId());
        assertEquals("Test Title", movie.getTitle());
        assertEquals("2022-01-01", movie.getReleaseDate());
        assertEquals("trailerLink", movie.getTrailerLink());
        assertEquals("poster", movie.getPoster());
        assertEquals(backdrops, movie.getBackdrops());
        assertEquals(genres, movie.getGenres());
    }

    @Test
    public void testMovieConstructorWithEmptyLists() {
        List<String> backdrops = new ArrayList<>();
        List<String> genres = new ArrayList<>();

        Movie movie = new Movie("tt1234567", "Test Title", "2022-01-01", "trailerLink", "poster", backdrops, genres);

        assertEquals("tt1234567", movie.getImdbId());
        assertEquals("Test Title", movie.getTitle());
        assertEquals("2022-01-01", movie.getReleaseDate());
        assertEquals("trailerLink", movie.getTrailerLink());
        assertEquals("poster", movie.getPoster());
        assertTrue(movie.getBackdrops().isEmpty());
        assertTrue(movie.getGenres().isEmpty());
    }
}
