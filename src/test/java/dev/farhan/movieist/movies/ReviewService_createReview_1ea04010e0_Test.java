// Test generated by RoostGPT for test springMongoDB using AI Type Open AI and AI Model gpt-4

package dev.farhan.movieist.movies;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;

import java.time.LocalDateTime;

import static org.mockito.Mockito.*;

public class ReviewService_createReview_1ea04010e0_Test {

    @InjectMocks
    ReviewService reviewService;

    @Mock
    ReviewRepository repository;

    @Mock
    MongoTemplate mongoTemplate;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateReview() {
        String reviewBody = "Great movie";
        String imdbId = "tt0111161";
        Review review = new Review(reviewBody, LocalDateTime.now(), LocalDateTime.now());

        when(repository.insert(any(Review.class))).thenReturn(review);

        reviewService.createReview(reviewBody, imdbId);

        verify(repository, times(1)).insert(any(Review.class));
        verify(mongoTemplate, times(1)).update(Movie.class);
        verify(mongoTemplate, times(1)).matching(Criteria.where("imdbId").is(imdbId));
        verify(mongoTemplate, times(1)).apply(new Update().push("reviews").value(review));
    }

    @Test
    public void testCreateReview_NullReviewBody() {
        String reviewBody = null;
        String imdbId = "tt0111161";

        assertThrows(IllegalArgumentException.class, () -> {
            reviewService.createReview(reviewBody, imdbId);
        });
    }
}
