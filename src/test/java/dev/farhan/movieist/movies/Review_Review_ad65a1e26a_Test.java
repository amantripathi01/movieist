// Test generated by RoostGPT for test springMongoDB using AI Type Open AI and AI Model gpt-4

package dev.farhan.movieist.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "reviews")
public class Review {
    private ObjectId id;
    private String body;
    private LocalDateTime created;
    private LocalDateTime updated;

    public Review(String body, LocalDateTime created, LocalDateTime updated) {
        this.body = body;
        this.created = created;
        this.updated = updated;
    }
}

public class Review_Review_ad65a1e26a_Test {

    @Test
    public void testReviewConstructor() {
        LocalDateTime created = LocalDateTime.now();
        LocalDateTime updated = LocalDateTime.now();
        Review review = new Review("Great Movie!", created, updated);

        assertEquals("Great Movie!", review.getBody());
        assertEquals(created, review.getCreated());
        assertEquals(updated, review.getUpdated());
    }

    @Test
    public void testReviewConstructor_NullBody() {
        LocalDateTime created = LocalDateTime.now();
        LocalDateTime updated = LocalDateTime.now();
        Review review = new Review(null, created, updated);

        assertNull(review.getBody());
        assertEquals(created, review.getCreated());
        assertEquals(updated, review.getUpdated());
    }

    // TODO: Add more test cases as needed
}
