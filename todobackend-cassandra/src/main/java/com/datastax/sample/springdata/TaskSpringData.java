package com.datastax.sample.springdata;

import java.io.Serializable;
import java.util.UUID;

//import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
//import org.springframework.data.cassandra.core.mapping.CassandraType;
//import org.springframework.data.cassandra.core.mapping.CassandraType.Name;
//import org.springframework.data.cassandra.core.mapping.Column;
//import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
//import org.springframework.data.cassandra.core.mapping.Table;

import com.datastax.sample.model.Task;
import com.datastax.sample.model.TodoAppSchema;

/**
 * Entity for table and Spring Data.
 *
 * @author Cedrick LUNVEN (@clunven)
 */
//@Table(value = TodoAppSchema.TABLE_TODO_TASKS)
public class TaskSpringData implements Serializable, Comparable<Task>, TodoAppSchema {

    private static final long serialVersionUID = -5844442448334944278L;
    
    //@PrimaryKeyColumn(
    //        name = TodoAppSchema.TASK_COL_UID, ordinal = 0, 
    //        type = PrimaryKeyType.PARTITIONED)
    //@CassandraType(type = Name.UUID)
    private UUID uuid;
    
    //@Column(TASK_COL_TITLE)
    //@CassandraType(type = Name.TEXT)
    private String title;

    //@Column(TASK_COL_COMPLETED)
    //@CassandraType(type = Name.BOOLEAN)
    private boolean completed = false;

    //@Column(TASK_COL_OFFSET)
    //@CassandraType(type = Name.INT)
    private int order = 0;
    
    public TaskSpringData() {}
  
    public Task mapAsTask() {
        Task t = new Task();
        t.setUuid(this.uuid);
        t.setCompleted(this.completed);
        t.setOrder(this.order);
        t.setTitle(this.title);
        return t;
    }
   
    public TaskSpringData(Task t) {
        this.uuid       = t.getUuid();
        this.title      = t.getTitle();
        this.order      = t.getOrder();
        this.completed  = t.isCompleted();
    }

    /** {@inheritDoc} */
    @Override
    public int compareTo(Task other) {
        if (other == null)
            return 1;
        return order - other.getOrder();
    }

    /**
     * Getter accessor for attribute 'uuid'.
     *
     * @return current value of 'uuid'
     */
    public UUID getUuid() {
        return uuid;
    }

    /**
     * Setter accessor for attribute 'uuid'.
     * 
     * @param uuid
     *            new value for 'uuid '
     */
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    /**
     * Getter accessor for attribute 'title'.
     *
     * @return current value of 'title'
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setter accessor for attribute 'title'.
     * 
     * @param title
     *            new value for 'title '
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Getter accessor for attribute 'completed'.
     *
     * @return current value of 'completed'
     */
    public boolean isCompleted() {
        return completed;
    }

    /**
     * Setter accessor for attribute 'completed'.
     * 
     * @param completed
     *            new value for 'completed '
     */
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    /**
     * Getter accessor for attribute 'order'.
     *
     * @return current value of 'order'
     */
    public int getOrder() {
        return order;
    }

    /**
     * Setter accessor for attribute 'order'.
     * 
     * @param order
     *            new value for 'order '
     */
    public void setOrder(int order) {
        this.order = order;
    }
    
}
