package com.meritis.meetup.frameworkless.server;

import org.jdbi.v3.core.Jdbi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

public class JdbiConfiguration {
    private Jdbi jdbi;

    public Jdbi createJdbi() {
        if (Objects.isNull(jdbi)) {
            try {
                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/bricoshop", "postgres", "admin");
                jdbi = Jdbi.create(connection);
            } catch (SQLException e) {
                throw new IllegalStateException("Unable to connect to database", e);
            }
        }
        return jdbi;
    }
}
