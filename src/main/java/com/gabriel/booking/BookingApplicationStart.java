/// Created By: Gabriel de Sousa Ferreira

package com.gabriel.booking;

import com.gabriel.booking.menu.HotelMenu;

import java.sql.SQLException;

public class BookingApplicationStart
{
    public static void main( String[] args ) throws SQLException {
        HotelMenu hotelMenu = new HotelMenu();

        hotelMenu.hotelMenuOptions();
    }
}
