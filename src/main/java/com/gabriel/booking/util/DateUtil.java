package com.gabriel.booking.util;

import com.gabriel.booking.exceptions.InvalidDateException;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static LocalDate parseDate(String date){
        try{
            return LocalDate.parse(date, formatter);
        } catch (DateTimeException e){
            throw new InvalidDateException("Formato de data invalido! Use o fomato dd/MM/yyyy.");
        }
    }
}