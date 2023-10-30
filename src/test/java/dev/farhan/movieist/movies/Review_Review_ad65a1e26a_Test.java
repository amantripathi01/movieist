package dev.farhan.movieist.movies;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.bson.types.ObjectId;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

public class Review_Review_ad65a1e26a_Test {

    private Review review;

    @BeforeEach
    public void setUp() {
        review = new Review();
        review.setBody("Great movie!");
        review.setCreated(LocalDateTime.now());
        review.setUpdated(LocalDateTime.now());
    }

    @Test
    public void testReviewBody() {
        String expectedBody = "Great movie!";
        assertEquals(expectedBody, review.getBody());
    }

    @Test
    public void testReviewCreatedDate() {
        assertNotNull(review.getCreated());
        assertTrue(review.getCreated().isBefore(LocalDateTime.now()) || review.getCreated().isEqual(LocalDateTime.now()));
    }

    @Test
    public void testReviewUpdatedDate() {
        assertNotNull(review.getUpdated());
        assertTrue(review.getUpdated().isBefore(LocalDateTime.now()) || review.getUpdated().isEqual(LocalDateTime.now()));
    }
}
