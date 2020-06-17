package com.datastax.sample.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.sample.model.Task;
import com.datastax.sample.objectmapper.TaskDao;
import com.datastax.sample.objectmapper.TaskDaoMapperBuilder;
import com.datastax.sample.objectmapper.TaskEntity;

/**
 * Default in-memory implementation of the repository.
 * 
 * Help to have a working application even in the beginning.
 * 
 * @author Cedrick LUNVEN (@clunven)
 */
//@Repository("todobackend.repo.cassandra-object-mapper")
public class TodoListRepositoryObjectMapperImpl implements TodoListRepository {

    /** CqlSession holding metadata to interact with Cassandra. */
    private TaskDao taskDao;
    
    /** External Initialization. */
    public TodoListRepositoryObjectMapperImpl(CqlSession cqlSession) {
        taskDao = new TaskDaoMapperBuilder(cqlSession)
                .build().taskDao(cqlSession.getKeyspace().get());
    }
    
    /** {@inheritDoc} */
    @Override
    public List<Task> findAll() {
        return taskDao.findAll().all().stream()
                      .map(TaskEntity::mapAsTask)
                      .collect(Collectors.toList());
    }
    
    /** {@inheritDoc} */
    @Override
    public void deleteAll() {
        taskDao.deleteAll();
    }
    
    /** {@inheritDoc} */
    @Override
    public Optional<Task> findById(UUID uid) {
        if (null == uid) return Optional.empty();
        Optional<TaskEntity> entity = taskDao.findById(uid);
        if (entity.isEmpty()) return Optional.empty();
        return Optional.ofNullable(entity.get().mapAsTask());
    }
    
    /** {@inheritDoc} */
    @Override
    public void upsert(Task dto) {
        if (null != dto) {
            taskDao.save(new TaskEntity(dto));
        }
    }
    
    /** {@inheritDoc} */
    @Override
    public void delete(UUID uid) {
        TaskEntity te = new TaskEntity();
        te.setUuid(uid);
        taskDao.delete(te);
    }
         
}
