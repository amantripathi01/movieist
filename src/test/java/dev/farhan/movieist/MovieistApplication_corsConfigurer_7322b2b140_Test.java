package dev.farhan.movieist;

import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static org.mockito.Mockito.*;

public class MovieistApplication_corsConfigurer_7322b2b140_Test {

    @Test
    public void testCorsConfigurer() {
        MovieistApplication application = new MovieistApplication();
        WebMvcConfigurer configurer = application.corsConfigurer();

        CorsRegistry registry = mock(CorsRegistry.class);
        configurer.addCorsMappings(registry);
        
        verify(registry, times(1)).addMapping("/**").allowedOrigins("*").allowedMethods("*").allowedHeaders("*").allowCredentials(false).maxAge(3600);
    }

    @Test
    public void testCorsConfigurerWithDifferentRegistry() {
        MovieistApplication application = new MovieistApplication();
        WebMvcConfigurer configurer = application.corsConfigurer();

        CorsRegistry registry = mock(CorsRegistry.class);
        configurer.addCorsMappings(registry);
        
        verify(registry, times(1)).addMapping("/**").allowedOrigins("*").allowedMethods("*").allowedHeaders("*").allowCredentials(false).maxAge(3600);
    }
}
