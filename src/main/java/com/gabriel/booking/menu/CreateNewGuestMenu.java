
package com.gabriel.booking.menu;

import com.gabriel.booking.entities.Guest;
import com.gabriel.booking.exceptions.InvalidCpfException;
import com.gabriel.booking.exceptions.InvalidEmailException;
import com.gabriel.booking.exceptions.InvalidPhoneException;
import com.gabriel.booking.service.GuestService;
import com.gabriel.booking.util.ImputReader;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class CreateNewGuestMenu {

    private static final String HEADER = "==================" +
                                        "\n=== Guest Menu ===" +
                                        "\n==================";

    private final GuestService guestService = new GuestService();

    public void createNewGuest() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(HEADER);
            System.out.println("Digite os dados do cliente:");

            try {
                System.out.print("Nome: ");
                String fullName = ImputReader.readName(scanner);

                System.out.print("CPF: ");
                String cpf = ImputReader.readCpf(scanner);

                System.out.print("Ano de nascimento: ");
                LocalDate birthDate = ImputReader.readBirthDate(scanner);

                System.out.print("E-mail: ");
                String email = ImputReader.readRequiredText(scanner, "E-mail");

                System.out.print("Telefone: ");
                String phone = ImputReader.readRequiredText(scanner, "Telefone");

                Guest guest = new Guest(
                        fullName, cpf, birthDate, email, phone
                );

                guestService.createGuest(guest);

                System.out.println("\nHóspede cadastrado com sucesso!");
                System.out.println("ID gerado pelo banco: " + guest.getId());

                System.out.println("Deseja ver os dados cadastrados? S/N");
                String option = scanner.nextLine().trim();

                if (option.equalsIgnoreCase("S")) {
                    System.out.println(guest);
                }

                break;
            } catch (InvalidCpfException | InvalidPhoneException | InvalidEmailException e) {
                System.out.println("\nErro " + e.getMessage());
                System.out.println("Por favor, tente cadastrar novamente.\n");

            } catch (SQLException e) {
                System.err.println("\nErro ao acessar o banco de dados.");
                System.err.println("Detalhes técnicos: " + e.getMessage());

                break;
            }
        }
    }
}
