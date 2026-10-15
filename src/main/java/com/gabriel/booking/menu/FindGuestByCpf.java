package com.gabriel.booking.menu;

import com.gabriel.booking.entities.Guest;
import com.gabriel.booking.repository.GuestRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class FindGuestByCpf {
    public void findGuestByCpf(){
        GuestRepository guestRepository = new GuestRepository();
        CreateNewGuestMenu createNewGuestMenu = new CreateNewGuestMenu();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o CPF do hóspede: ");
        String cpf = scanner.nextLine().trim();

        try {
            Guest guest = guestRepository.findGuestByCpf(cpf);

            if (guest != null){
                System.out.println("\nHóspede encontrado:");
                System.out.println("Nome: " + guest.getFullName());
                System.out.println("CPF: " + guest.getCpf());
            } else {
                System.out.println("Nenhum hospede encontrado com este cpf!");
                System.out.println("Deseja fazer o cadastro de um novo hóspede? S/N");
                String option = scanner.nextLine().toUpperCase();

                if (option.equalsIgnoreCase("S")) {
                    createNewGuestMenu.createNewGuest();
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao tentar acessar o banco de dados!");
            e.printStackTrace();
        }
    }
}
