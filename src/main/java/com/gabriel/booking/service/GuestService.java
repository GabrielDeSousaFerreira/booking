package com.gabriel.booking.service;

import com.gabriel.booking.entities.Guest;
import com.gabriel.booking.exceptions.InvalidCpfException;
import com.gabriel.booking.exceptions.InvalidEmailException;
import com.gabriel.booking.exceptions.InvalidPhoneException;
import com.gabriel.booking.repository.GuestRepository;

import java.sql.SQLException;
import java.util.List;

public class GuestService {
     private final GuestRepository guestRepository;

     public GuestService(){
         this.guestRepository = new GuestRepository();
     }

    public Guest createGuest(Guest guest) throws SQLException {
        if (guest == null) {
            throw new IllegalArgumentException(
                    "Os dados do hóspede não podem ser vazios!"
            );
        }

        if (guestRepository.existsByCpf(guest.getCpf())) {
            throw new InvalidCpfException(
                    "O CPF informado já está cadastrado!"
            );
        }

        if (guestRepository.existsByEmail(guest.getEmail())) {
            throw new InvalidEmailException(
                    "O e-mail informado já está cadastrado!"
            );
        }

        if (guestRepository.existsByPhone(guest.getPhone())) {
            throw new InvalidPhoneException(
                    "O telefone informado já está cadastrado!"
            );
        }

        return guestRepository.save(guest);
    }

    public List<Guest> listAllGuests() throws SQLException {
        return guestRepository.listAllGuests();
    }
}
