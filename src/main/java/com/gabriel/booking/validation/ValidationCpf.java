package com.gabriel.booking.validation;

import com.gabriel.booking.exceptions.InvalidCpfException;

public class ValidationCpf {
    public static String validation(String cpf){
        cpf = cpf.replaceAll("\\D", "");

        if (cpf.length() != 11){
            throw new InvalidCpfException("CPF deve conter 11 números!");
        }

        if (cpf.matches("(\\d)\\1{10}")){
            throw new InvalidCpfException("CPF invalido!");
        }

        return cpf;
    }
}
