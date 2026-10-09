package com.gabriel.booking.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String URL =
            "jdbc:postgresql://localhost:5432/booking_DB";

    private static final String USER =
            System.getenv("BOOKING_DB_USER");

    private static final String PASSWORD =
            System.getenv("BOOKING_DB_PASSWORD");

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
