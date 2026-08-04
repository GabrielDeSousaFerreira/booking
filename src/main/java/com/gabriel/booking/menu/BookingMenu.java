package com.gabriel.booking.menu;

import java.util.*;

public class BookingMenu {
    public void HotelOptions(){
        Scanner scanner = new Scanner(System.in);
        int option;

        do{
            System.out.println("==== HOTEL ====\n");
            System.out.println("Selecione uma das opções:");
            System.out.println("1- Cadastrar cliente");
            System.out.println("2- Nova reserva");
            System.out.println("3- Check-In");
            System.out.println("4- Check-Out");
            System.out.println("5- Listar quartos disponíveis");
            System.out.println("6- Listar quartos ocupados");
            System.out.println("7- Buscar cliente");
            System.out.println("8- Buscar reserva");
            System.out.println("9- Cancelar reserva");
            System.out.println("10- Relatório do Hotel");
            System.out.println("0- Sair");
            option = scanner.nextInt();

            switch (option){
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 9:

                    break;
                case 10:

                    break;
                case 0:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção invalida, digite novamente!");

            }
        } while (option != 0);
    }
}
