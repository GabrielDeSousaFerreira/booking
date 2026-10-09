/// Created By: Gabriel de Sousa Ferreira

package com.gabriel.booking;

import com.gabriel.booking.menu.HotelMenu;

public class BookingApplicationStart
{
    public static void main( String[] args )
    {
        HotelMenu hotelMenu = new HotelMenu();

        hotelMenu.hotelMenuOptions();
    }
}
