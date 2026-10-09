package com.gabriel.booking;

import com.gabriel.booking.config.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class Teste {
    public static void main(String[] args) {

        try (Connection connection = ConnectionFactory.getConnection()) {

            if (connection != null && connection.isValid(2)) {
                System.out.println("Conexão com PostgreSQL realizada com sucesso!");
                System.out.println("Banco de dados: "
                        + connection.getCatalog());
            }

        } catch (SQLException e) {
            System.out.println("Falha ao conectar com o PostgreSQL.");
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
