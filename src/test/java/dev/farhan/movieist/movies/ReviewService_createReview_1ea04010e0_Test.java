package dev.farhan.movieist.movies;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.query.Query;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ReviewService_createReview_1ea04010e0_Test {

    @InjectMocks
    private ReviewService reviewService;

    @Mock
    private ReviewRepository repository;

    @Mock
    private MongoTemplate mongoTemplate;

    private Review review;

    @BeforeEach
    public void setUp() {
        review = new Review("Great Movie!", LocalDateTime.now(), LocalDateTime.now());
        when(repository.insert(any(Review.class))).thenReturn(review);
    }

    @Test
    public void testCreateReview() {
        String imdbId = "tt0111161";
        Review result = reviewService.createReview(review.getReviewBody(), imdbId);

        verify(repository, times(1)).insert(any(Review.class));
        verify(mongoTemplate, times(1)).updateFirst(any(Query.class), any(Update.class), any(Class.class));

        assertNotNull(result);
    }

    @Test
    public void testCreateReviewWithEmptyReview() {
        String imdbId = "tt0111161";
        Review emptyReview = new Review("", LocalDateTime.now(), LocalDateTime.now());
        when(repository.insert(any(Review.class))).thenReturn(emptyReview);

        Review result = reviewService.createReview(emptyReview.getReviewBody(), imdbId);

        verify(repository, times(1)).insert(any(Review.class));
        verify(mongoTemplate, times(1)).updateFirst(any(Query.class), any(Update.class), any(Class.class));

        assertNotNull(result);
        assertTrue(result.getReviewBody().isEmpty());
    }
}
