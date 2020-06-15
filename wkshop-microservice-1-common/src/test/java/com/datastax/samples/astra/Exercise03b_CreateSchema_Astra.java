package com.datastax.samples.astra;

import java.nio.file.Paths;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.SimpleStatement;
import com.datastax.oss.driver.api.core.type.DataTypes;
import com.datastax.oss.driver.api.querybuilder.SchemaBuilder;
import com.datastax.samples.TodoAppSchema;

public class Exercise03b_CreateSchema_Astra implements TodoAppSchema, AstraSettings {

    /** Logger for the class. */
    private static Logger LOGGER = LoggerFactory.getLogger(Exercise03b_CreateSchema_Astra.class);

    @Test
    public void should_create_expected_table() {
        
        try (CqlSession cqlSession = CqlSession.builder()
                .withCloudSecureConnectBundle(Paths.get(ASTRA_ZIP_FILE))
                .withAuthCredentials(ASTRA_USERNAME, ASTRA_PASSWORD)
                .withKeyspace(ASTRA_KEYSPACE)
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
            
            // SELECT table_name from tables WHERE keyspace_name='todoapp';
            
        }
    }
}
