package dev.farhan.movieist.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Arrays;

@SpringBootTest
public class Movie_Movie_d09d4293c0_Test {

    private Movie movie;

    @Test
    public void testMovieConstructor() {
        ObjectId id = new ObjectId();
        String imdbId = "tt1234567";
        String title = "Test Movie";
        String releaseDate = "2022-01-01";
        String trailerLink = "http://trailerlink.com";
        String poster = "http://posterlink.com";
        List<String> backdrops = Arrays.asList("http://backdroplink1.com", "http://backdroplink2.com");
        List<String> genres = Arrays.asList("Action", "Adventure");
        List<Review> reviews = new ArrayList<>();

        movie = new Movie();
        movie.setId(id);
        movie.setImdbId(imdbId);
        movie.setTitle(title);
        movie.setReleaseDate(releaseDate);
        movie.setTrailerLink(trailerLink);
        movie.setPoster(poster);
        movie.setBackdrops(backdrops);
        movie.setGenres(genres);
        movie.setReviews(reviews);

        Assert.notNull(movie, "Movie object is null");
        Assert.isTrue(movie.getImdbId().equals(imdbId), "Mismatch in imdbId");
        Assert.isTrue(movie.getTitle().equals(title), "Mismatch in title");
        Assert.isTrue(movie.getReleaseDate().equals(releaseDate), "Mismatch in releaseDate");
        Assert.isTrue(movie.getTrailerLink().equals(trailerLink), "Mismatch in trailerLink");
        Assert.isTrue(movie.getPoster().equals(poster), "Mismatch in poster");
        Assert.isTrue(movie.getBackdrops().equals(backdrops), "Mismatch in backdrops");
        Assert.isTrue(movie.getGenres().equals(genres), "Mismatch in genres");
    }

    @Test
    public void testMovieConstructorWithNullValues() {
        movie = new Movie();
        movie.setId(null);
        movie.setImdbId(null);
        movie.setTitle(null);
        movie.setReleaseDate(null);
        movie.setTrailerLink(null);
        movie.setPoster(null);
        movie.setBackdrops(null);
        movie.setGenres(null);
        movie.setReviews(null);

        Assert.notNull(movie, "Movie object is null");
        Assert.isNull(movie.getImdbId(), "imdbId is not null");
        Assert.isNull(movie.getTitle(), "Title is not null");
        Assert.isNull(movie.getReleaseDate(), "Release date is not null");
        Assert.isNull(movie.getTrailerLink(), "Trailer link is not null");
        Assert.isNull(movie.getPoster(), "Poster is not null");
        Assert.isNull(movie.getBackdrops(), "Backdrops is not null");
        Assert.isNull(movie.getGenres(), "Genres is not null");
    }
}
