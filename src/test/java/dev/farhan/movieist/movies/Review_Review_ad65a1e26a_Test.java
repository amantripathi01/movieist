package dev.farhan.movieist.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "reviews")
public class Review {

    private ObjectId id;
    private String body;
    private LocalDateTime created;
    private LocalDateTime updated;
}

package dev.farhan.movieist.movies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

public class Review_Review_ad65a1e26a_Test {

    private Review review;

    @BeforeEach
    public void setup() {
        review = new Review();
    }

    @Test
    public void testReviewConstructor() {
        ObjectId id = new ObjectId();
        LocalDateTime created = LocalDateTime.now();
        LocalDateTime updated = LocalDateTime.now();
        review = new Review(id, "Great movie!", created, updated);
        Assertions.assertNotNull(review);
        Assertions.assertEquals(id, review.getId());
        Assertions.assertEquals("Great movie!", review.getBody());
        Assertions.assertEquals(created, review.getCreated());
        Assertions.assertEquals(updated, review.getUpdated());
    }

    @Test
    public void testReviewConstructor_NullBody() {
        ObjectId id = new ObjectId();
        LocalDateTime created = LocalDateTime.now();
        LocalDateTime updated = LocalDateTime.now();
        review = new Review(id, null, created, updated);
        Assertions.assertNull(review.getBody());
        Assertions.assertEquals(id, review.getId());
        Assertions.assertEquals(created, review.getCreated());
        Assertions.assertEquals(updated, review.getUpdated());
    }
}
