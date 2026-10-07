/// Created By: Gabriel de Sousa Ferreira

package com.gabriel.booking;

import com.gabriel.booking.service.HotelService;

public class BookingApplicationStart
{
    public static void main( String[] args )
    {
        HotelService hotelMenu = new HotelService();

        hotelMenu.hotelServiceOtions();
    }
}
