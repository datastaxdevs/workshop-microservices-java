package com.datastax.samples.local;

import java.net.InetSocketAddress;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.SimpleStatement;
import com.datastax.oss.driver.api.core.type.DataTypes;
import com.datastax.oss.driver.api.querybuilder.SchemaBuilder;
import com.datastax.samples.TodoAppSchema;

public class Exercise03b_CreateSchema_Local implements TodoAppSchema, CassandraSettings {

    /** Logger for the class. */
    private static Logger LOGGER = LoggerFactory.getLogger(Exercise03b_CreateSchema_Local.class);

    @Test
    public void should_create_expected_table() {
        
        SimpleStatement stmtCreateKeyspace = SchemaBuilder.createKeyspace(KEYSPACENAME)
                .ifNotExists()
                .withSimpleStrategy(3)
                .withDurableWrites(true)
                .build();
        
        // Create Keyspace
        try (CqlSession cqlSession = CqlSession.builder()
                .addContactPoint(new InetSocketAddress(CONTACT_POINT, CASSANDRA_PORT))
                .withLocalDatacenter(LOCALDATACENTER)
                .build()) {
            cqlSession.execute(stmtCreateKeyspace);
            LOGGER.info("+ Keyspace '{}' created (if needed).", KEYSPACENAME);
        }
        
        // Create the table inside the keyspace
        try (CqlSession cqlSession = CqlSession.builder()
                .addContactPoint(new InetSocketAddress(CONTACT_POINT, CASSANDRA_PORT))
                .withLocalDatacenter(LOCALDATACENTER)
                .withKeyspace(KEYSPACENAME)
                .build()) {
            
            // Given a statement
            SimpleStatement stmtCreateTable = SchemaBuilder.createTable(TABLE_TODO_TASKS).ifNotExists()
                    .withPartitionKey(TASK_COL_UID, DataTypes.UUID)
                    .withColumn(TASK_COL_TITLE, DataTypes.TEXT)
                    .withColumn(TASK_COL_COMPLETED, DataTypes.BOOLEAN)
                    .withColumn(TASK_COL_OFFSET, DataTypes.INT)
                    .build();
            
            // When creating the table
            cqlSession.execute(stmtCreateTable);
            
            // Then table is created
            LOGGER.info("+ Table '{}' has been created (if needed).", TABLE_TODO_TASKS);
        }
    }
}
