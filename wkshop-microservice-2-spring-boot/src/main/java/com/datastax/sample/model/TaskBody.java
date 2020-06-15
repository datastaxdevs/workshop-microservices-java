package com.datastax.sample.model;

import java.io.Serializable;

public class TaskBody implements Serializable {

    /** Serial. */
    private static final long serialVersionUID = -7930662827102682933L;
    
    /** Title. */
    private String title;
    
    /** Status. */
    private boolean completed = false;
    
    /** order field. */
    private int order = -1;
    
    /**
     * Default constructor
     */
    public TaskBody() {
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
     *      new value for 'title '
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
     *      new value for 'completed '
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
    public int getOrder() {
        return order;
    }

    /**
     * Setter accessor for attribute 'order'.
     * @param order
     *      new value for 'order '
     */
    public void setOrder(int order) {
        this.order = order;
    }

}
