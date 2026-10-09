package com.gabriel.booking.repository;

import com.gabriel.booking.config.ConnectionFactory;
import com.gabriel.booking.entities.Guest;

import java.sql.*;

public class GuestRepository {
    public Guest save(Guest guest) throws SQLException {
        String sql = """
                INSERT INTO guest
                    (full_name, cpf, birth_date, email, phone, active)
                VALUES (?, ?, ?, ?, ?, ?)
                """;

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     sql, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, guest.getFullName());
            statement.setString(2, guest.getCpf());
            statement.setObject(3, guest.getBirthDate());
            statement.setString(4, guest.getEmail());
            statement.setString(5, guest.getPhone());
            statement.setBoolean(6, guest.isActive());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected == 0) {
                throw new SQLException("O cadastro do hóspede não foi realizado.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    guest.setId(generatedKeys.getLong(1));
                } else {
                    throw new SQLException(
                            "Não foi possível obter o ID gerado pelo banco.");
                }
            }
        }

        return guest;
    }
}
