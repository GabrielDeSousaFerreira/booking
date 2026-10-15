package com.gabriel.booking.repository;

import com.gabriel.booking.config.ConnectionFactory;
import com.gabriel.booking.entities.Guest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public Guest findGuestByCpf(String cpf) throws SQLException{
        String sql = """
                    SELECT cpf, full_name
                    FROM guest
                    WHERE cpf = ?
                """;

        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, cpf);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Guest guest = new Guest();

                    guest.setCpf(resultSet.getString("cpf"));
                    guest.setFullName(resultSet.getString("full_name"));

                    return guest;
                }
            }
        }

        return null;
    }

    public List<Guest> listAllGuests() throws SQLException {
        String sql = """
                    SELECT cpf, full_name
                    FROM guest
                    ORDER BY full_name ASC
                """;
        List<Guest> list = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()){

            while (resultSet.next()){
                String fullName = resultSet.getString("full_name");
                String cpf = resultSet.getString("cpf");

                Guest guest = new Guest(fullName, cpf);
                list.add(guest);
            }
        } catch (SQLException e){
            System.err.println("Erro ao listar os hóspedes!");
            e.printStackTrace();
        }

        return list;
    }

    public boolean existsByCpf(String cpf) throws SQLException{
        String sql = "SELECT 1 FROM guest WHERE cpf = ?";

        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, cpf);

            try (ResultSet resultSet = statement.executeQuery()){
                return resultSet.next();
            }
        }
    }

    public boolean existsByEmail(String email) throws SQLException {
        String sql = "SELECT 1 FROM guest WHERE LOWER(email) = LOWER(?)";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, email.trim());

            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            }
        }
    }

    public boolean existsByPhone(String phone) throws SQLException {
        String sql = "SELECT 1 FROM guest WHERE phone = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, phone);

            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            }
        }
    }

}
