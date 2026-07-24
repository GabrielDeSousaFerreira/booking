package com.gabriel.booking;

import com.gabriel.booking.config.ConnectionFactory;

import java.sql.Connection;

/**
 * Hello world!
 *
 */
public class BookingApplicationStart
{
    public static void main( String[] args )
    {
        try (Connection connection = ConnectionFactory.getConnection()) {
            System.out.println("Conectado ao PostgreSQL!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
