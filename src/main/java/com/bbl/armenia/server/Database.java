package com.bbl.armenia.server;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

public class Database {
    private static final Logger LOGGER = LoggerFactory.getLogger(Database.class);

    private static final String URL = "jdbc:mysql://localhost/bblarmenia";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final Optional<DSLContext> JOOQ = connect();

    private static Optional<DSLContext> connect() {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            return Optional.of(DSL.using(connection, SQLDialect.HSQLDB));
        } catch (SQLException e) {
            LOGGER.error("Error occurred while getting HSQLDB connection", e);
        }

        return Optional.empty();
    }

    public static DSLContext getJOOQ() {
        if (JOOQ.isPresent()) {
            return JOOQ.get();
        }

        String failedAcquiringJOOQ = "Error occurred while trying to acquire JOOQ instance";
        LOGGER.error(failedAcquiringJOOQ);
        throw new RuntimeException(failedAcquiringJOOQ);
    }
}
