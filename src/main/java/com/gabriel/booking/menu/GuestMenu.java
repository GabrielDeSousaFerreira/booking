package com.gabriel.booking.menu;

import com.gabriel.booking.entities.Guest;
import com.gabriel.booking.util.DateUtil;
import com.gabriel.booking.util.ImputReader;
import com.gabriel.booking.validation.ValidationCpf;

import java.util.Scanner;
import java.time.*;

public class GuestMenu {
    private static final String HEADER = "====================" +
            "\n=    Guest Menu    =" +
            "\n====================";

    public void CreateGuestMenu(){
        Scanner scanner = new Scanner(System.in);

        System.out.println(HEADER + "\n");
        System.out.println("Digite os dados do cliente:\n");
        System.out.print("Nome: ");
        String fullName = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = ImputReader.readCpf(scanner);
        System.out.print("Ano de nascimento: ");
        LocalDate birthDate = ImputReader.readBirthDate(scanner);
        System.out.print("E-mail: ");
        String email = scanner.nextLine();
        System.out.print("Telefone: ");
        String phone = scanner.nextLine();

        Guest guest = new Guest(fullName, cpf, birthDate, email, phone);

        System.out.println("\nDeseja ver os dados? S/N");
        char st = scanner.next().toUpperCase().charAt(0);

        if (st == 'S'){
            System.out.println(guest);
        }
    }
}