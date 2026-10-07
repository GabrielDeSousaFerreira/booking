package com.gabriel.booking.service;

import com.gabriel.booking.menu.GuestMenu;

import java.util.Scanner;

public class GuestService {
    private static final String HEADER = "=====================" +
                                        "\n=== Guest Service ===" +
                                        "\n=====================";

    public void guestServiceMenu(){
        Scanner scanner = new Scanner(System.in);
        GuestMenu guestMenu = new GuestMenu();
        HotelService hotelService = new HotelService();
        int option;

        do{
            System.out.println("\n" + HEADER);
            System.out.println("1- Novo cadastro");
            System.out.println("2- Encontrar cliente");
            System.out.println("3- Listar clientes");
            System.out.println("4- Validar CPF existente");
            System.out.println("0- voltar ao menu anterior");
            option = scanner.nextInt();

            switch (option){
                case 1:
                    guestMenu.createNewGuest();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 0:
                    hotelService.hotelServiceOtions();
                    break;
                default:
                    System.out.println("Opção invalida!");
            }
        } while (option != 0);
    }
}
