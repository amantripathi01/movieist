package dev.farhan.movieist.movies;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ReviewController_createReview_f145916c42_Test {

    @Autowired
    private ReviewController reviewController;

    @MockBean
    private ReviewService reviewService;

    @Test
    public void testCreateReview() {
        Map<String, String> payload = new HashMap<>();
        payload.put("reviewBody", "Great Movie");
        payload.put("imdbId", "tt1234567");

        Review mockReview = new Review();
        // Assuming the Review class has these setter methods
        // If not, you might need to adjust this part
        mockReview.setReviewBody("Great Movie");
        mockReview.setImdbId("tt1234567");

        when(reviewService.createReview("Great Movie", "tt1234567")).thenReturn(mockReview);

        ResponseEntity<Review> responseEntity = reviewController.createReview(payload);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockReview, responseEntity.getBody());
    }

    @Test
    public void testCreateReviewWithInvalidPayload() {
        Map<String, String> payload = new HashMap<>();
        payload.put("reviewBody", "Great Movie");

        // This part is not clear from your question, but I assume that 
        // when the payload is invalid (missing imdbId), the service method 
        // should return null, and the controller method should return 
        // a ResponseEntity with HttpStatus.BAD_REQUEST
        when(reviewService.createReview("Great Movie", null)).thenReturn(null);

        ResponseEntity<Review> responseEntity = reviewController.createReview(payload);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }
}
