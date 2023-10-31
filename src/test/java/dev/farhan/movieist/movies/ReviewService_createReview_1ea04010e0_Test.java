package dev.farhan.movieist.movies;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ReviewService_createReview_1ea04010e0_Test {

    @Mock
    private ReviewRepository repository;

    @Mock
    private MongoTemplate mongoTemplate;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateReview() {
        String reviewBody = "Great Movie!";
        String imdbId = "tt1234567";

        Review review = new Review();
        review.setBody(reviewBody);
        review.setCreatedAt(LocalDateTime.now());
        review.setUpdatedAt(LocalDateTime.now());
        when(repository.insert(any(Review.class))).thenReturn(review);

        mongoTemplate.updateFirst(Query.query(Criteria.where("imdbId").is(imdbId)), 
            new Update().push("reviews", review), Movie.class);

        Review result = repository.insert(review);
        assertEquals(review, result);
        verify(repository, times(1)).insert(any(Review.class));
    }

    @Test
    public void testCreateReview_NullReviewBody() {
        String imdbId = "tt1234567";

        assertThrows(IllegalArgumentException.class, () -> {
            Review review = new Review();
            review.setBody(null);
            review.setCreatedAt(LocalDateTime.now());
            review.setUpdatedAt(LocalDateTime.now());
            repository.insert(review);
        });
    }

    @Test
    public void testCreateReview_NullImdbId() {
        String reviewBody = "Great Movie!";

        assertThrows(IllegalArgumentException.class, () -> {
            Review review = new Review();
            review.setBody(reviewBody);
            review.setCreatedAt(LocalDateTime.now());
            review.setUpdatedAt(LocalDateTime.now());
            repository.insert(review);
        });
    }
}
