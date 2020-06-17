package com.datastax.sample.springdata;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
//import org.springframework.data.cassandra.config.AbstractSessionConfiguration;

import com.datastax.oss.driver.api.core.CqlSession;

/**
 * Configuration Cassandra Driver <-> Spring Data.
 * 
 * This Full java config approach is all about overriding method from
 * {@link AbstractCassandraConfiguration} but we have no access to CqlSession creation
 * 
 * #FIX: I got timeout issue for Keyspace creation and no access to request timeout objects
 *
 * @see AbstractSessionConfiguration
 * @see AbstractCassandraConfiguration
 *
 * @author Cedrick LUNVEN (@clunven)
 */
//@Configuration
public class SpringDataCassandraJavaConfig /*extends AbstractCassandraConfiguration*/ {
    
    /** Create CqlSession. */
    //@Bean
    public CqlSession cqlSession() {
        return CqlSession.builder().build();
    }
    
    /** {@inheritDoc} */
    //@Override
    protected String getKeyspaceName() {
        return cqlSession().getKeyspace().get().toString();
    }
    
    /** {@inheritDoc} */
    //@Override
    public String[] getEntityBasePackages() {
        return new String[]{ "com.datastax.sample.springdata" };
    }    

}
