package com.gabriel.booking.util;

import com.gabriel.booking.exceptions.InvalidCpfException;
import com.gabriel.booking.exceptions.InvalidDateException;
import com.gabriel.booking.validation.ValidationCpf;

import java.time.LocalDate;
import java.util.Scanner;

public class ImputReader {
    public static String readCpf(Scanner scanner){
        while (true){
            try {
                return ValidationCpf.validation(scanner.nextLine());
            } catch (InvalidCpfException e){
                System.out.println(e.getMessage());
                System.out.print("CPF: ");
            }
        }
    }

    public static LocalDate readBirthDate(Scanner scanner){
        while (true){
            try {
                return DateUtil.parseDate(scanner.nextLine());
            } catch (InvalidDateException e){
                System.out.println(e.getMessage());
                System.out.print("Ano de nascimento: ");
            }
        }
    }
}