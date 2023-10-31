package dev.farhan.movieist.movies;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class Review_Review_ad65a1e26a_Test {

    private Review review;

    @BeforeEach
    public void setUp() {
        review = new Review();
    }

    @Test
    public void testReviewConstructorSuccess() {
        LocalDateTime created = LocalDateTime.now();
        LocalDateTime updated = LocalDateTime.now();
        String body = "This is a test review";

        review.setBody(body);
        review.setCreated(created);
        review.setUpdated(updated);

        assertEquals(body, review.getBody());
        assertEquals(created, review.getCreated());
        assertEquals(updated, review.getUpdated());
    }

    @Test
    public void testReviewConstructorFailure() {
        LocalDateTime created = LocalDateTime.now();
        LocalDateTime updated = null;
        String body = "";

        assertThrows(IllegalArgumentException.class, () -> {
            review.setBody(body);
            review.setCreated(created);
            review.setUpdated(updated);
        });
    }
}
