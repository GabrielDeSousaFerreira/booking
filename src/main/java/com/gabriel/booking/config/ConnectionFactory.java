package com.gabriel.booking.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String URL = "jdbc:postgresql://localhost:5432/booking_DB";
    private static final String USER = "postgres";
    private static final String PASSWORD = "224466";

    public static Connection getConnection(){
        try{
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
