package com.gabriel.booking.entities;

import java.time.LocalDate;

public class Guest {
    private long id;
    private String fullName;
    private String cpf;
    private LocalDate birthDate;
    private String email;
    private String phone;
    private boolean isActive;
    private LocalDate createdAt;

    public Guest(String fullName, String cpf, LocalDate birthDate, String email, String phone) {
        this.fullName = fullName;
        this.cpf = cpf;
        this.birthDate = birthDate;
        this.email = email;
        this.phone = phone;
        this.isActive = false;
        this.createdAt = LocalDate.now();
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

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
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
                "\nCriado em: " + createdAt +
                "\nEstá ativo? " + isActive;
    }
}
