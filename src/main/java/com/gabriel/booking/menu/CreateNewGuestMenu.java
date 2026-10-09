package com.gabriel.booking.menu;

import com.gabriel.booking.entities.Guest;
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

    public void createNewGuest(){
        Scanner scanner = new Scanner(System.in);

        System.out.println(HEADER);
        System.out.println("Digite os dados do cliente:");
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

        Guest guest = new Guest(fullName, cpf, birthDate, email, phone);

        try{
            guestService.createGuest(guest);

            System.out.println("\nHóspede cadastrado com sucesso!");
            System.out.println("ID gerado pelo banco: " + guest.getId());

            System.out.println("Deseja ver os dados cadastrados? S/N");
            char st = scanner.nextLine().trim().toUpperCase().charAt(0);

            if (st == 'S'){
                System.out.println(guest);
            }
        } catch (SQLException e){
            System.out.println("Erro ao salvar o hóspede no banco de dados.");

            if("23505".equals(e.getSQLState())){
                System.err.println("O CPF informado já existe!");
            } else{
                System.err.println("Detalhes: " + e.getMessage());
            }
        }
    }
}