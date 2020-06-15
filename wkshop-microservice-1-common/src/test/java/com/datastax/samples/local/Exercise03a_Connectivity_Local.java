package com.datastax.samples.local;

import java.net.InetSocketAddress;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datastax.oss.driver.api.core.CqlSession;

public class Exercise03a_Connectivity_Local implements CassandraSettings {

    /** Logger for the class. */
    private static Logger LOGGER = LoggerFactory.getLogger(Exercise03a_Connectivity_Local.class);

    @Test
    public void should_connect_to_Cassandra() {
        try (CqlSession cqlSession = CqlSession.builder()
                .addContactPoint(new InetSocketAddress(CONTACT_POINT, CASSANDRA_PORT))
                .withLocalDatacenter(LOCALDATACENTER)
                .build()) {
            LOGGER.info(" + [OK] - Connection Established to Local Cluster");
        }
    }

}
