package com.datastax.sample.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.sample.entity.Task;

/**
 * Default in-memory implementation of the repository.
 * 
 * Help to have a working application even in the beginning.
 * 
 * @author Cedrick LUNVEN (@clunven)
 */
@Repository("todobackend.repo.cassandra-driver")
public class TodoListRepositoryCassandraDriverImpl implements TodoListRepository {
    
    @Autowired
    public CqlSession cqlSession;
    
    /** {@inheritDoc} */
    @Override
    public List<Task> findAll() {
        return null;
    }
    
    /** {@inheritDoc} */
    @Override
    public void deleteAll() {
        
    }
    
    /** {@inheritDoc} */
    @Override
    public Optional<Task> findById(UUID uid) {
        return null;
    }
    
    /** {@inheritDoc} */
    @Override
    public void upsert(Task dto) {
    }
    
    /** {@inheritDoc} */
    @Override
    public void delete(UUID uid) {
    }
         
}
