package MVC.controller;

import MVC.model.Person;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import static java.time.LocalDate.now;

public class PersonController {

    public static int calcAge(Person p){
//        Age initialize at -1, since an age can't be below 0
        int age = -1;
//        Takes substring from cpr
        String birthdate = p.getCpr().substring(0,6);
//        Formats date, so it can read the string as a date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyy");
//        Converts String to date, using the formatter
        LocalDate d = LocalDate.parse(birthdate, formatter);
//        If the date is after current time, subtract 100 years to get actual date of birth
//        This is because it tries to go for dates after the year 2000 first
        if(d.isAfter(now())){
            d=d.minusYears(100);
        }
//        Set age as the amount of years between now and birth date and return it
        age = Period.between(d, now()).getYears();
        return age;
    }
}
