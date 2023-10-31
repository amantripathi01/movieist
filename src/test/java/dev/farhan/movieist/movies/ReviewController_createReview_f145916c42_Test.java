package dev.farhan.movieist.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class ReviewController_createReview_f145916c42_Test {

    @Autowired
    ReviewService service;

    ReviewController reviewController;

    @BeforeEach
    public void setUp() {
        reviewController = new ReviewController();
        reviewController.service = service;
    }

    @Test
    public void testCreateReviewSuccess() {
        Map<String, String> payload = Mockito.mock(Map.class);
        Review review = new Review();
        when(payload.get("reviewBody")).thenReturn("Great movie!");
        when(payload.get("imdbId")).thenReturn("tt1234567");
        when(service.createReview("Great movie!", "tt1234567")).thenReturn(review);
        ResponseEntity<Review> response = reviewController.createReview(payload);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(review, response.getBody());
    }

    @Test
    public void testCreateReviewFailure() {
        Map<String, String> payload = Mockito.mock(Map.class);
        when(payload.get("reviewBody")).thenReturn(null);
        when(payload.get("imdbId")).thenReturn("tt1234567");
        ResponseEntity<Review> response = reviewController.createReview(payload);
        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }
}
