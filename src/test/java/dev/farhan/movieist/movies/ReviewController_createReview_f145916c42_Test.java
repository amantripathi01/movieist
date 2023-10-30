package dev.farhan.movieist.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
public class ReviewController_createReview_f145916c42_Test {

    @InjectMocks
    private ReviewController reviewController;

    @Mock
    private ReviewService reviewService;

    @Test
    public void testCreateReview_Success() {
        Review mockReview = new Review();
        when(reviewService.createReview(anyString(), anyString())).thenReturn(mockReview);

        Map<String, String> payload = new HashMap<>();
        payload.put("reviewBody", "Great Movie!");
        payload.put("imdbId", "tt0111161");

        ResponseEntity<Review> responseEntity = reviewController.createReview(payload);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockReview, responseEntity.getBody());
    }

    @Test
    public void testCreateReview_Failure() {
        when(reviewService.createReview(anyString(), anyString())).thenReturn(null);

        Map<String, String> payload = new HashMap<>();
        payload.put("reviewBody", "Bad Movie!");
        payload.put("imdbId", "tt0111161");

        ResponseEntity<Review> responseEntity = reviewController.createReview(payload);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(null, responseEntity.getBody());
    }
}
