package com.datastax.sample.model;

import java.io.Serializable;
import java.util.UUID;

/**
 * Object to be exposed in the REST API.
 *
 * @author Cedrick LUNVEN (@clunven)
 */
public class TaskResource implements Serializable {

    /** Serial. */
    private static final long serialVersionUID = -7930662827102682933L;
    
    /** Hate Oas logic. */
    private String url;
    
    /** Unique id for the task. */
    private UUID uuid;
    
    /** Title. */
    private String title;
    
    /** Status. */
    private boolean completed = false;
    
    /** order field. */
    private int order = 0;
    
    /**
     * Default constructor.
     */
    public TaskResource() {}
    
    /**
     * Create from the dto and target URL.
     *
     * @param requestURL
     *      current URL for the request
     * @param dto
     *      dto from DB
     */
    public TaskResource(String url, Task dto) {
        if (null != dto) {
            this.url       = url;
            this.uuid      = dto.getUuid();
            this.title     = dto.getTitle();
            this.completed = dto.isCompleted();
            this.order     = dto.getOrder();
        }
    }

    /**
     * Getter accessor for attribute 'url'.
     *
     * @return
     *       current value of 'url'
     */
    public String getUrl() {
        return url;
    }

    /**
     * Setter accessor for attribute 'url'.
     * @param url
     * 		new value for 'url '
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Getter accessor for attribute 'uuid'.
     *
     * @return
     *       current value of 'uuid'
     */
    public UUID getUuid() {
        return uuid;
    }

    /**
     * Setter accessor for attribute 'uuid'.
     * @param uuid
     * 		new value for 'uuid '
     */
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
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
     * 		new value for 'order '
     */
    public void setOrder(int order) {
        this.order = order;
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

}
