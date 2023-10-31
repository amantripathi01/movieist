// Test generated by RoostGPT for test springMongoDB using AI Type Open AI and AI Model gpt-4

package dev.farhan.movieist.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import java.util.List;
import java.util.Arrays; // added missing import
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
        String imdbId = "tt1234567";
        String title = "Test Movie";
        String releaseDate = "2022-01-01";
        String trailerLink = "https://example.com/trailer";
        String poster = "https://example.com/poster.jpg";
        List<String> backdrops = Arrays.asList("https://example.com/backdrop1.jpg", "https://example.com/backdrop2.jpg");
        List<String> genres = Arrays.asList("Action", "Thriller");

        Movie movie = new Movie(imdbId, title, releaseDate, trailerLink, poster, backdrops, genres);

        Assertions.assertEquals(imdbId, movie.getImdbId());
        Assertions.assertEquals(title, movie.getTitle());
        Assertions.assertEquals(releaseDate, movie.getReleaseDate());
        Assertions.assertEquals(trailerLink, movie.getTrailerLink());
        Assertions.assertEquals(poster, movie.getPoster());
        Assertions.assertEquals(backdrops, movie.getBackdrops());
        Assertions.assertEquals(genres, movie.getGenres());
    }

    @Test
    public void testMovieConstructorWithNullValues() {
        Movie movie = new Movie(null, null, null, null, null, null, null);

        Assertions.assertNull(movie.getImdbId());
        Assertions.assertNull(movie.getTitle());
        Assertions.assertNull(movie.getReleaseDate());
        Assertions.assertNull(movie.getTrailerLink());
        Assertions.assertNull(movie.getPoster());
        Assertions.assertNull(movie.getBackdrops());
        Assertions.assertNull(movie.getGenres());
    }
}
