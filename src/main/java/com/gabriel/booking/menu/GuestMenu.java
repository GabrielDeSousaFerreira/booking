package com.gabriel.booking.menu;

import java.sql.SQLException;
import java.util.Scanner;

public class GuestMenu {
    private static final String HEADER = "==================" +
                                        "\n=== Guest Menu ===" +
                                        "\n==================";

    public void guestMenu() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        HotelMenu hotelMenu = new HotelMenu();
        CreateNewGuestMenu createNewGuestMenu = new CreateNewGuestMenu();
        FindGuestByCpf findGuestByCpf = new FindGuestByCpf();
        ListGuestsMenu listGuestsMenu =  new ListGuestsMenu();
        int option;

        do{
            System.out.println(HEADER);
            System.out.println("1- Novo cadastro");
            System.out.println("2- Encontrar cliente");
            System.out.println("3- Listar clientes");
            System.out.println("4- Validar CPF existente");
            System.out.println("0- voltar ao menu anterior");
            option = scanner.nextInt();

            switch (option){
                case 1:
                    createNewGuestMenu.createNewGuest();
                    break;
                case 2:
                    findGuestByCpf.findGuestByCpf();
                    break;
                case 3:
                    listGuestsMenu.listAllGuestsMenu();
                    break;
                case 4:

                    break;
                case 0:
                    hotelMenu.hotelMenuOptions();
                    break;
                default:
                    System.out.println("Opção invalida!");
            }
        } while (option != 0);
    }
}
