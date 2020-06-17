package com.datastax.sample.springdata;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.cassandra.CqlSessionBuilderCustomizer;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.AbstractSessionConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.DataCenterReplication;
import org.springframework.data.cassandra.core.cql.keyspace.KeyspaceOption;
import org.springframework.data.cassandra.core.cql.session.init.KeyspacePopulator;
import org.springframework.data.cassandra.core.cql.session.init.ResourceKeyspacePopulator;

import com.datastax.oss.driver.api.core.CqlSessionBuilder;
import com.datastax.sample.SpringDataApplication;

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
@Configuration
public class SpringDataCassandraJavaConfig 
                extends AbstractCassandraConfiguration 
                implements CqlSessionBuilderCustomizer {
    
    @Override
    protected String getKeyspaceName() {
        return keyspaceName;
    }
    
    @Override
    protected String getLocalDataCenter() {
        return localDataCenter;
    }
    
    @Override
    protected String getContactPoints() {
        return contactPoints;
    }
    /** {@inheritDoc} */
    @Override
    protected int getPort() {
        return port;
    }
    /** {@inheritDoc} */
    @Override
    public void customize(CqlSessionBuilder cqlSessionBuilder) {
        //cqlSessionBuilder.
        // Here you define the SecureCloudConnectBundle for ASTRA
    }
    
    @Value("${spring.data.cassandra.keyspace-name:springdemo}")
    private String keyspaceName;
    
    @Value("${spring.data.cassandra.local-datacenter:dc1}")
    private String localDataCenter;
    
    @Value("${spring.data.cassandra.contact-point:localhost}")
    private String contactPoints;
    
    @Value("${spring.data.cassandra.port:9042}")
    private int port;
    
    /** {@inheritDoc} */
    @Override
    protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
        return Arrays.asList(CreateKeyspaceSpecification
                .createKeyspace(getKeyspaceName())
                .ifNotExists(true)
                .withNetworkReplication(DataCenterReplication.of(getLocalDataCenter(), 3))
                .with(KeyspaceOption.DURABLE_WRITES));
    }
    
    /** {@inheritDoc} */
    @Override
    public String[] getEntityBasePackages() {
        return new String[]{ SpringDataApplication.class.getPackageName() + ".entity" };
    }
    
    /** {@inheritDoc} */
    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }
    
    /** {@inheritDoc} */
    @Override
    protected KeyspacePopulator keyspacePopulator() {
        ResourceKeyspacePopulator keyspacePopulate = new ResourceKeyspacePopulator();
        keyspacePopulate.setSeparator(";");
        keyspacePopulate.setScripts(new ClassPathResource("sample-data.cql"));
        return keyspacePopulate;
    }
    

}
