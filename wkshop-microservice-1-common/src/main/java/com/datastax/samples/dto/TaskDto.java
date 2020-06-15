package com.datastax.samples.dto;

import java.io.Serializable;
import java.util.UUID;

/**
 * Record in the todo table
 * 
 * @author Cedrick LUNVEN (@clunven)
 */
public class TaskDto implements Serializable {
    
    /** Serial. */
    private static final long serialVersionUID = 1207126491865242970L;
    
    /**
     * Unique identifier 
     */
    private UUID uid;
    
    /**
     * Title for the task
     */
    private String title;
    
    /**
     * Flag to enable/disable the task
     */
    private boolean completed;
    
    /**
     * Order to sort
     */
    private Long order;
    
    /**
     * Default Constructor
     */
    public TaskDto() {
    }
    
    /**
     * Full constructor.
     * 
     * @param uid
     *      unique identifier for the task
     * @param title
     *      title of the task
     * @param completed
     *      completion flag
     * @param order
     *      order in the list
     */
    public TaskDto(UUID uid, String title, boolean completed, Long order) {
        super();
        this.uid = uid;
        this.title = title;
        this.completed = completed;
        this.order = order;
    }

    /**
     * Getter accessor for attribute 'title'.
     *
     * @return
     *       current value of 'title'
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setter accessor for attribute 'title'.
     * @param title
     * 		new value for 'title '
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Getter accessor for attribute 'completed'.
     *
     * @return
     *       current value of 'completed'
     */
    public boolean isCompleted() {
        return completed;
    }

    /**
     * Setter accessor for attribute 'completed'.
     * @param completed
     * 		new value for 'completed '
     */
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    /**
     * Getter accessor for attribute 'order'.
     *
     * @return
     *       current value of 'order'
     */
    public Long getOrder() {
        return order;
    }

    /**
     * Setter accessor for attribute 'order'.
     * @param order
     * 		new value for 'order '
     */
    public void setOrder(Long order) {
        this.order = order;
    }

    /**
     * Getter accessor for attribute 'uid'.
     *
     * @return
     *       current value of 'uid'
     */
    public UUID getUid() {
        return uid;
    }

    /**
     * Setter accessor for attribute 'uid'.
     * @param uid
     * 		new value for 'uid '
     */
    public void setUid(UUID uid) {
        this.uid = uid;
    }

}
