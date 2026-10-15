package com.gabriel.booking.menu;

import com.gabriel.booking.entities.Guest;
import com.gabriel.booking.service.GuestService;

import java.sql.SQLException;
import java.util.List;

public class ListGuestsMenu {
    GuestService guestService = new GuestService();

    public void listAllGuestsMenu() throws SQLException {
        List<Guest> guests = guestService.listAllGuests();

        if (guests.isEmpty()){
            System.out.println("Nenhum hóspede cadastrado para fazer a lista!");
        } else {
            System.out.println("Hóspedes cadastrados:");
            for (Guest guest : guests){
                System.out.println("CPF: " + guest.getCpf() + " | Nome: " + guest.getFullName());
            }
            System.out.println();
        }
    }
}
