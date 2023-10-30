package dev.farhan.movieist.movies;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.UpdateResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;

public class ReviewService_createReview_1ea04010e0_Test {

    @InjectMocks
    private ReviewService reviewService;

    @Mock
    private ReviewRepository repository;

    @Mock
    private MongoTemplate mongoTemplate;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateReview_Success() {
        String reviewBody = "Great Movie!";
        String imdbId = "tt1234567";
        Review mockReview = new Review();
        mockReview.setReviewBody(reviewBody);
        mockReview.setCreatedTime(LocalDateTime.now());
        mockReview.setUpdatedTime(LocalDateTime.now());

        when(repository.insert(any(Review.class))).thenReturn(mockReview);
        when(mongoTemplate.update(Movie.class)).thenReturn(mockUpdate);
        when(mockUpdate.matching(any(Criteria.class))).thenReturn(mockUpdate);
        when(mockUpdate.apply(any(Update.class))).thenReturn(mockUpdate);
        when(mockUpdate.first()).thenReturn(UpdateResult.acknowledged());

        Review result = reviewService.createReview(reviewBody, imdbId);

        verify(repository, times(1)).insert(any(Review.class));
        verify(mongoTemplate, times(1)).update(Movie.class);
        verify(mockUpdate, times(1)).matching(any(Criteria.class));
        verify(mockUpdate, times(1)).apply(any(Update.class));

        assertNotNull(result);
        assertEquals(reviewBody, result.getReviewBody());
    }

    @Test
    public void testCreateReview_Failure() {
        String reviewBody = "Great Movie!";
        String imdbId = "tt1234567";

        when(repository.insert(any(Review.class))).thenReturn(null);

        Review result = reviewService.createReview(reviewBody, imdbId);

        verify(repository, times(1)).insert(any(Review.class));
        verify(mongoTemplate, times(0)).update(Movie.class);

        assertEquals(null, result);
    }
}
