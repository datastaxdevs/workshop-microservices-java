package com.datastax.sample.objectmapper;

import java.util.Optional;
import java.util.UUID;

import com.datastax.oss.driver.api.core.PagingIterable;
import com.datastax.oss.driver.api.mapper.annotations.Dao;
import com.datastax.oss.driver.api.mapper.annotations.Delete;
import com.datastax.oss.driver.api.mapper.annotations.Insert;
import com.datastax.oss.driver.api.mapper.annotations.Query;
import com.datastax.oss.driver.api.mapper.annotations.Select;
import com.datastax.sample.model.TodoAppSchema;

@Dao
public interface TaskDao {
    
    @Select
    Optional<TaskEntity> findById(UUID taskId);
     
    @Insert
    void save(TaskEntity product);

    @Delete
    void delete(TaskEntity product);
    
    @Query("SELECT * FROM ${tableId}")
    PagingIterable<TaskEntity> findAll();
    
    @Query("TRUNCATE TABLE " + TodoAppSchema.TABLE_TODO_TASKS)
    void deleteAll();

}
