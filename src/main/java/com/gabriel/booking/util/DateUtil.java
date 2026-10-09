package com.gabriel.booking.util;

import com.gabriel.booking.exceptions.InvalidDateException;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Locale;

public class DateUtil {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu", Locale.ROOT).withResolverStyle(ResolverStyle.STRICT);
    private static final int MAX_AGE = 120;

    public static LocalDate parseDate(String value){
        final LocalDate birthDate;

        try{
            birthDate = LocalDate.parse(value, formatter);
        } catch (DateTimeException e){
            throw new InvalidDateException("Formato de data invalido! Use o fomato dd/MM/yyyy.");
        }

        LocalDate today = LocalDate.now();

        if (birthDate.isAfter(today)){
            throw new InvalidDateException("A data de nascimento não pode passar do futuro!");
        }

        int age = Period.between(birthDate, today).getYears();

        if (age > MAX_AGE){
            throw new InvalidDateException("A idada máxima permitida para cadastro é " + MAX_AGE + " anos.");
        }

        return birthDate;
    }
}