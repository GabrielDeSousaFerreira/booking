package com.gabriel.booking.service;

import com.gabriel.booking.entities.Guest;
import com.gabriel.booking.repository.GuestRepository;

import java.sql.SQLException;

public class GuestService {
     private final GuestRepository guestRepository;

     public GuestService(){
         this.guestRepository = new GuestRepository();
     }

     public Guest createGuest(Guest guest) throws SQLException{
         if (guest == null){
             throw new IllegalArgumentException("Os dados do hóspede não podem ser vazios!");
         }

         return guestRepository.save(guest);
     }
}
