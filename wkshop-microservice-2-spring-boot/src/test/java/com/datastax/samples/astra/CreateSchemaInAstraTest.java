package com.datastax.samples.astra;

import java.io.File;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.config.DriverConfigLoader;
import com.datastax.oss.driver.api.core.cql.SimpleStatement;
import com.datastax.oss.driver.api.core.type.DataTypes;
import com.datastax.oss.driver.api.querybuilder.SchemaBuilder;
import com.datastax.samples.TodoAppSchema;

public class CreateSchemaInAstraTest implements TodoAppSchema {

    /** Logger for the class. */
    private static Logger LOGGER = LoggerFactory.getLogger(CreateSchemaInAstraTest.class);

    @Test
    public void should_create_expected_table() {
        
        // Config loader from file
        DriverConfigLoader loader = DriverConfigLoader.fromFile(
                new File(ConnectivityToAstraTest.class.getResource("/test_astra.conf").getFile()));
        
        // Use it to create the session
        try (CqlSession cqlSession = CqlSession.builder().withConfigLoader(loader).build()) {
        
            LOGGER.info("Connection Established to Astra with Keyspace '{}'", 
                    cqlSession.getKeyspace().get());
            
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
            LOGGER.info("Table '{}' has been created (if needed).", TABLE_TODO_TASKS);
            
            // List tables
            SimpleStatement stmtListTableNames = SimpleStatement.builder(
                    "SELECT table_name from tables WHERE keyspace_name= 'todoapp'")
                    //.addNamedValue("kspace", cqlSession.getKeyspace().get())
                    .build();
            cqlSession.execute(stmtListTableNames).all().stream().forEach(row -> 
                System.out.println(row.getColumnDefinitions())
                //LOGGER.info("+ Table '{}' in keyspace '{}'", row.getString("table_name"), cqlSession.getKeyspace().get())
            );
        }
    }
}
