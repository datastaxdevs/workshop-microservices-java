package com.datastax.samples.astra;

import java.io.File;
import java.util.UUID;

import javax.annotation.PreDestroy;

import org.junit.jupiter.api.Assertions;
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
import com.datastax.sample.repository.TodoListRepositoryObjectMapperImpl;

/**
 * Test CRUD with ObjectMapper
 *
 * @author Cedrick LUNVEN (@clunven)
 */
@RunWith(JUnitPlatform.class)
@SpringJUnitConfig
public class CrudWithObjectMapperTest {
    
    /** Logger for the class. */
    private static Logger LOGGER = LoggerFactory.getLogger(CrudWithObjectMapperTest.class);
    
    @TestConfiguration
    static class MyTestConfiguration {
  
        @Bean
        public CqlSession cqlSession() {
            String configFile = CrudWithCassandraDriverIntegrationTest.class.getResource("/application_test.conf").getFile();
            DriverConfigLoader configLoader = DriverConfigLoader.fromFile(new File(configFile));
            return CqlSession.builder().withConfigLoader(configLoader).build();
        }
        
        @Bean
        public TodoListRepository initRepo(CqlSession cqlSession) {
            return new TodoListRepositoryObjectMapperImpl(cqlSession);
        }
    }
    
    @Autowired
    private CqlSession cqlSession;
    
    @Autowired
    private TodoListRepository todoRepo;
    
    @Test
    public void should_all_crud() {
        LOGGER.info("Starting CRUD Test");
        // Given an empty table
        UUID newUid = UUID.randomUUID();
        todoRepo.deleteAll();
        Assertions.assertEquals(0, todoRepo.findAll().size());
        LOGGER.info("+ Table has been empty");
        
        // When adding a new Task
        todoRepo.upsert(new Task(newUid, "CrudWithCassandraDriverIntegrationTest", false, 1));
        // Then you should have a table of size 1
        Assertions.assertEquals(1, todoRepo.findAll().size());
        LOGGER.info("+ a New Task {} has been created", newUid);
        
        // Then you can find this task
        Assertions.assertFalse(todoRepo.findById(newUid).isEmpty());
        LOGGER.info("+ And I can retrieve it", newUid);
        // And WHEN you delete it
        todoRepo.delete(newUid);
        // Then this is empty again
        Assertions.assertEquals(0, todoRepo.findAll().size());
        LOGGER.info("+ And now this is removed", newUid);
    }
    
    @PreDestroy
    public void closeSession() {
        if (null != cqlSession) {
            cqlSession.close();
        }
    }

}
