package com.gabriel.booking.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Guest {
    private Long id;
    private String fullName;
    private String cpf;
    private LocalDate birthDate;
    private String email;
    private String phone;
    private boolean isActive;
    private LocalDateTime createdAt;
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public Guest(String fullName, String cpf, LocalDate birthDate, String email, String phone) {
        this.fullName = fullName;
        this.cpf = cpf;
        this.birthDate = birthDate;
        this.email = email;
        this.phone = phone;
        this.isActive = true;
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "=== Guest ===" +
                "\nNome: " + fullName +
                "\nCPF: " + cpf  +
                "\nData de nascimento: " + birthDate +
                "\nE-mail: " + email +
                "\nTelefone: " + phone  +
                "\nCriado em: " + createdAt.format(DATE_TIME_FORMATTER) +
                "\nEstá ativo? " + isActive;
    }
}
