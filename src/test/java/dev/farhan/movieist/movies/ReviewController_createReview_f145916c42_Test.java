// Test generated by RoostGPT for test springMongoDB using AI Type Open AI and AI Model gpt-4

package dev.farhan.movieist.movies;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class ReviewController_createReview_f145916c42_Test {

    @InjectMocks
    ReviewController reviewController;

    @Mock
    ReviewService reviewService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateReviewSuccess() {
        Review review = new Review();
        review.setReviewBody("Great movie!");
        review.setImdbId("tt1234567");

        when(reviewService.createReview(anyString(), anyString())).thenReturn(review);

        Map<String, String> payload = new HashMap<>();
        payload.put("reviewBody", "Great movie!");
        payload.put("imdbId", "tt1234567");

        ResponseEntity<Review> result = reviewController.createReview(payload);

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals("Great movie!", result.getBody().getReviewBody());
        assertEquals("tt1234567", result.getBody().getImdbId());
    }

    @Test
    public void testCreateReviewFailure() {
        when(reviewService.createReview(anyString(), anyString())).thenReturn(null);

        Map<String, String> payload = new HashMap<>();
        payload.put("reviewBody", "Bad movie!");
        payload.put("imdbId", "tt7654321");

        ResponseEntity<Review> result = reviewController.createReview(payload);

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(null, result.getBody());
    }
}
