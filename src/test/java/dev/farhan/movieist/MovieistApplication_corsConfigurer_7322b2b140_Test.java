package dev.farhan.movieist;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MovieistApplication_corsConfigurer_7322b2b140_Test {

    @InjectMocks
    private MovieistApplication movieistApplication;

    @Mock
    private CorsRegistry corsRegistry;

    @Test
    public void testCorsConfigurer() {

        WebMvcConfigurer webMvcConfigurer = movieistApplication.corsConfigurer();

        // Simulate the call to the corsConfigurer method
        webMvcConfigurer.addCorsMappings(corsRegistry);

        // Verify that the addMapping method was called with the correct parameters
        verify(corsRegistry, times(1)).addMapping("/**");
    }

    @Test
    public void testCorsConfigurerWithNullRegistry() {

        WebMvcConfigurer webMvcConfigurer = movieistApplication.corsConfigurer();

        // Simulate the call to the corsConfigurer method with null registry
        webMvcConfigurer.addCorsMappings(null);

        // Verify that the addMapping method was not called
        verify(corsRegistry, times(0)).addMapping(anyString());
    }
}
