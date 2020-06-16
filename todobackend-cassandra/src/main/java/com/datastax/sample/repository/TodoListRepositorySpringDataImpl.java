package com.datastax.sample.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.datastax.sample.model.Task;

/**
 * Default in-memory implementation of the repository.
 * 
 * Help to have a working application even in the beginning.
 * 
 * @author Cedrick LUNVEN (@clunven)
 */
@Repository("todobackend.repo.inmemory")
public class TodoListRepositorySpringDataImpl implements TodoListRepository {

    /** This will be our storage in memory. */
    private Map<UUID, Task> mapOfTasks = new ConcurrentHashMap<>();
    
    /** {@inheritDoc} */
    @Override
    public List<Task> findAll() {
        return new ArrayList<>(mapOfTasks.values());
    }
    
    /** {@inheritDoc} */
    @Override
    public void deleteAll() {
        mapOfTasks.clear();
    }
    
    /** {@inheritDoc} */
    @Override
    public Optional<Task> findById(UUID uid) {
        if (null == uid) return Optional.empty();
        return Optional.ofNullable(mapOfTasks.get(uid));
    }
    
    /** {@inheritDoc} */
    @Override
    public void upsert(Task dto) {
        if (null != dto) {
            mapOfTasks.put(dto.getUuid(), dto);
        }
    }
    
    /** {@inheritDoc} */
    @Override
    public void delete(UUID uid) {
        mapOfTasks.remove(uid);
    }
    
    @PostConstruct
    public void populate() {
        Task one   = new Task("one");
        Task two   = new Task("two");
        Task three = new Task("three");
        mapOfTasks.put(one.getUuid(), one);
        mapOfTasks.put(two.getUuid(), two);
        mapOfTasks.put(three.getUuid(), three);
    }
         
}
