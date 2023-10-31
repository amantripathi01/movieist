package dev.farhan.movieist.movies;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ReviewController_createReview_f145916c42_Test {

    @Mock
    private ReviewService service;

    @InjectMocks
    private ReviewController reviewController;

    @Test
    public void testCreateReview_Success() {
        Map<String, String> payload = new HashMap<>();
        payload.put("reviewBody", "Great Movie!");
        payload.put("imdbId", "tt1234567");

        Review review = new Review();
        // Assuming Review class has setters for reviewBody and imdbId
        review.setReviewBody(payload.get("reviewBody"));
        review.setImdbId(payload.get("imdbId"));

        Mockito.when(service.createReview(payload.get("reviewBody"), payload.get("imdbId"))).thenReturn(review);

        ResponseEntity<Review> response = reviewController.createReview(payload);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(review, response.getBody());
    }

    @Test
    public void testCreateReview_Failure() {
        Map<String, String> payload = new HashMap<>();
        payload.put("reviewBody", "Great Movie!");

        Mockito.when(service.createReview(payload.get("reviewBody"), null)).thenThrow(new IllegalArgumentException("imdbId is missing"));

        ResponseEntity<Review> response = reviewController.createReview(payload);

        assertNotNull(response);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }
}
