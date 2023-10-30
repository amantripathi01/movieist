package dev.farhan.movieist;

import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static org.junit.jupiter.api.Assertions.*;

public class MovieistApplication_corsConfigurer_7322b2b140_Test {

    @Test
    public void testCorsConfigurer() {
        MovieistApplication movieistApplication = new MovieistApplication();
        WebMvcConfigurer webMvcConfigurer = movieistApplication.corsConfigurer();

        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setMethod("GET");
        request.addHeader("Origin", "http://example.com");

        MockHttpServletResponse response = new MockHttpServletResponse();

        webMvcConfigurer.getCorsConfiguration(request, response);

        CorsConfiguration corsConfiguration = response.getCorsConfiguration();

        assertNotNull(corsConfiguration, "CorsConfiguration should not be null");
        assertTrue(corsConfiguration.getAllowedOrigins().contains("*"), "Allowed origins should contain *");
        assertTrue(corsConfiguration.getAllowedMethods().contains("*"), "Allowed methods should contain *");
        assertTrue(corsConfiguration.getAllowedHeaders().contains("*"), "Allowed headers should contain *");
        assertFalse(corsConfiguration.getAllowCredentials(), "Allow credentials should be false");
        assertEquals(Long.valueOf(3600), corsConfiguration.getMaxAge(), "Max age should be 3600");
    }
}
