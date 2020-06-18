package com.datastax.sample.springdata;

import java.util.Optional;
import java.util.UUID;

//import org.springframework.data.cassandra.repository.CassandraRepository;
//import org.springframework.data.cassandra.repository.Query;
//import org.springframework.stereotype.Repository;

import com.datastax.sample.model.TodoAppSchema;

/*
@Repository("todobackend.repo.spring")
public interface TaskSpringDataRepository 
        extends TodoAppSchema, CassandraRepository<TaskSpringData, UUID> {
    
    @Query("SELECT * FROM " + TodoAppSchema.TABLE_TODO_TASKS + 
          " WHERE " + TodoAppSchema.TASK_COL_UID + " = ?0")
    Optional<TaskSpringData> findByTaskByIdO(UUID taskid);
    
}
*/

