package com.datastax.sample.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.datastax.oss.driver.api.core.CqlSession;

/**
 * Configuration of connectivity with Cassandra.
 */
@Configuration
public class CassandraDriverConfig {
    
    @Bean
    public CqlSession cqlSession() {
        return CqlSession.builder().build();
    }

}
