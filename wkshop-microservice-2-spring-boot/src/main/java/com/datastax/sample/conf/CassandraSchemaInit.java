package com.datastax.sample.conf;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.SimpleStatement;
import com.datastax.oss.driver.api.core.metadata.Node;
import com.datastax.oss.driver.api.querybuilder.SchemaBuilder;

public class CassandraSchemaInit {
    
    /** Some logger. */
    private static final Logger LOGGER = LoggerFactory.getLogger(CassandraSchemaInit.class);
   
    @Autowired
    public CqlSession cqlSession;
    
    @Value("${cassandra.keyspace}")
    public String keyspaceName;
    
    /**
     * We want the demo to create the objects it may need as the keyspace.
     * Working with a single node required SimpleStrategy where multi dc required NetworkTopology
     */
    @PostConstruct
    public void createKeyspaceIfNotExist() {
        Map <String, Integer > nodesPerDc = new HashMap<>();
        int totalNode =0;
        LOGGER.info("List of Cassandra nodes:");
        for (Node host : cqlSession.getMetadata().getNodes().values()) {
            LOGGER.info("+ '{}/{}': ip='{}',listen='{}'", 
                    host.getDatacenter(), host.getRack(),
                    host.getBroadcastAddress().orElse(null),
                    host.getListenAddress().orElse(null));
            if (!nodesPerDc.containsKey(host.getDatacenter())) {
                nodesPerDc.put(host.getDatacenter(), 1);
            } else {
                nodesPerDc.put(host.getDatacenter(), nodesPerDc.get(host.getDatacenter()) + 1);
            }
            totalNode++;
        }
        LOGGER.info("Create Keyspace '{}' if needed", keyspaceName);
        SimpleStatement createKeyspaceStmt;
        if (1 == totalNode) {
            createKeyspaceStmt = SchemaBuilder.createKeyspace(keyspaceName)
                    .ifNotExists()
                    .withSimpleStrategy(1)
                    .withDurableWrites(true)
                    .build();
        } else {
            createKeyspaceStmt = SchemaBuilder.createKeyspace(keyspaceName)
                    .ifNotExists()
                    .withNetworkTopologyStrategy(nodesPerDc)
                    .withDurableWrites(true)
                    .build();
        }
        LOGGER.info("+ {}", createKeyspaceStmt.getQuery());
        cqlSession.execute(createKeyspaceStmt);
    }

}
