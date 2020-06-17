package com.datastax.sample.objectmapper;

import java.io.Serializable;
import java.util.UUID;

import com.datastax.oss.driver.api.mapper.annotations.CqlName;
import com.datastax.oss.driver.api.mapper.annotations.Entity;
import com.datastax.oss.driver.api.mapper.annotations.PartitionKey;
import com.datastax.sample.model.Task;
import com.datastax.sample.model.TodoAppSchema;

@Entity
@CqlName(TodoAppSchema.TABLE_TODO_TASKS)
public class TaskEntity implements Serializable, Comparable<Task>, TodoAppSchema {

    /** Serial. */
    private static final long serialVersionUID = 6344665847226250633L;

    /** Unique id for the task. */
    @CqlName(TASK_COL_UID)
    @PartitionKey
    private UUID uuid;

    /** Title. */
    @CqlName(TASK_COL_TITLE)
    private String title;

    /** Status. */
    @CqlName(TASK_COL_COMPLETED)
    private boolean completed = false;

    /** order field. */
    @CqlName(TASK_COL_OFFSET)
    private int order = 0;

    /**
     * Constructors.
     */
    public TaskEntity() {}
    
    public Task mapAsTask() {
        Task t = new Task();
        t.setUuid(this.uuid);
        t.setCompleted(this.completed);
        t.setOrder(this.order);
        t.setTitle(this.title);
        return t;
    }
    
    public TaskEntity(Task t) {
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
