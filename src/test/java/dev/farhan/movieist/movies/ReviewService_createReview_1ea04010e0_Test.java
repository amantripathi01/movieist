package dev.farhan.movieist.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;

@ExtendWith(MockitoExtension.class)
public class ReviewService_createReview_1ea04010e0_Test {

    @Mock
    private ReviewRepository repository;

    @Mock
    private MongoTemplate mongoTemplate;

    @InjectMocks
    private ReviewService reviewService;

    @Test
    public void testCreateReview_SuccessCase() {
        String reviewBody = "Great Movie!";
        String imdbId = "tt1234567";
        Review review = new Review(reviewBody, LocalDateTime.now(), LocalDateTime.now());

        when(repository.insert(any(Review.class))).thenReturn(review);
        when(mongoTemplate.updateFirst(any(Query.class), any(Update.class), eq(Movie.class))).thenReturn(null);

        Review actualReview = reviewService.createReview(reviewBody, imdbId);

        verify(repository, times(1)).insert(any(Review.class));
        verify(mongoTemplate, times(1)).updateFirst(any(Query.class), any(Update.class), eq(Movie.class));

        assertEquals(review, actualReview);
    }

    @Test
    public void testCreateReview_FailureCase() {
        String reviewBody = "Great Movie!";
        String imdbId = "tt1234567";

        when(repository.insert(any(Review.class))).thenReturn(null);

        Review actualReview = reviewService.createReview(reviewBody, imdbId);

        verify(repository, times(1)).insert(any(Review.class));
        assertNull(actualReview);
    }
}
