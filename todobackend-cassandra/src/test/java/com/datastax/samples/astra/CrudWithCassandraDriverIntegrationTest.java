package com.datastax.samples.astra;

import java.io.File;
import java.util.UUID;

import javax.annotation.PreDestroy;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.config.DriverConfigLoader;
import com.datastax.sample.model.Task;
import com.datastax.sample.repository.TodoListRepository;
import com.datastax.sample.repository.TodoListRepositoryCassandraDriverImpl;

/**
 * Junit5 + Spring.
 * @author Cedrick LUNVEN (@clunven)
 */
@RunWith(JUnitPlatform.class)
@SpringJUnitConfig
public class CrudWithCassandraDriverIntegrationTest {

    /** Logger for the class. */
    private static Logger LOGGER = 
            LoggerFactory.getLogger(CrudWithCassandraDriverIntegrationTest.class);
    
    @TestConfiguration
    static class CrudWithCassandraDriverConfiguration {
  
        @Bean
        public CqlSession cqlSession() {
            String configFile = CrudWithCassandraDriverIntegrationTest.class.getResource("/application_test.conf").getFile();
            DriverConfigLoader configLoader = DriverConfigLoader.fromFile(new File(configFile));
            return CqlSession.builder().withConfigLoader(configLoader).build();
        }
        
        @Bean
        public TodoListRepository initRepo(CqlSession cqlSession) {
            TodoListRepositoryCassandraDriverImpl repo = new  TodoListRepositoryCassandraDriverImpl(cqlSession);
            repo.initStatements();
            return repo;
        }
    }
    
    @Autowired
    private CqlSession cqlSession;
    
    @Autowired
    private TodoListRepository todoRepo;
    
    @Test
    public void should_create_task_with_new_uid() {
        LOGGER.info("Testing 'upsert' for insert");
        // Given
        UUID newUid = UUID.randomUUID();
        // When
        todoRepo.upsert(new Task(newUid, "CrudWithCassandraDriverIntegrationTest", false, 1));
        // Then
    }
    
    @PreDestroy
    public void closeSession() {
        if (null != cqlSession) {
            cqlSession.close();
        }
    }
}
