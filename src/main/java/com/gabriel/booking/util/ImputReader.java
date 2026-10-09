package com.gabriel.booking.util;

import com.gabriel.booking.exceptions.InvalidCpfException;
import com.gabriel.booking.exceptions.InvalidDateException;
import com.gabriel.booking.validation.ValidationCpf;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ImputReader {
    public static String readCpf(Scanner scanner){
        while (true){
            try {
                String cpf = readRequiredText(scanner, "CPF").trim();
                return ValidationCpf.validation(cpf);
            } catch (InvalidCpfException e){
                System.out.println(e.getMessage());
                System.out.print("CPF: ");
            }
        }
    }

    public static LocalDate readBirthDate(Scanner scanner){
        while (true){
            try {
                String birthDate = readRequiredText(scanner, "Ano de Nascimento").trim();
                return DateUtil.parseDate(birthDate);
            } catch (InvalidDateException e){
                System.out.println(e.getMessage());
                System.out.print("Ano de nascimento: ");
            }
        }
    }

    public static String readRequiredText(Scanner scanner, String fideldName){
        while (true){
            String value = scanner.nextLine().trim();

            if (!value.isEmpty()){
                return value;
            }

            System.out.println("Erro: o campo " + fideldName + " não pode ficar vazio!");
            System.out.print(fideldName + ": ");
        }
    }

    public static String readName(Scanner scanner){
        Pattern pattern = Pattern.compile(
                "^[\\p{L}]+(?:[ '-][\\p{L}]+)*$"
        );

        while (true){
            String name = readRequiredText(scanner, "Nome");

            if (pattern.matcher(name).matches()){
                return name;
            }

            System.out.println("Nome inválodo! Digite apenas letras, espaços, apóstrofos ou hífens.");
            System.out.println("Nome: ");
        }
    }
}