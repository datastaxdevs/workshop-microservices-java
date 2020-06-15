package com.datastax.sample.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Add a CORS Filter to allow cross-origin
 *
 * @author Cedrick LUNVEN (@clunven)
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    
    /**
     * By overriding `addCorsMappings` from {@link WebMvcConfigurer}, 
     * we allow access with the full JavaScript Access.
     * 
     * {@inheritDoc}
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }
    
    /**
     * By overriding `addResourceHandlers` from {@link WebMvcConfigurer}, 
     * we tell SpringMVC not to use Thymeleaf to access Swagger UI
     * 
     * {@inheritDoc}
     */
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
