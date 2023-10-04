package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class PersonNumberDateCheck implements ValidityCheck {

    @Override
    public boolean check(String number) {
        String datePart;

        if (number.length() == 10 || number.length() == 11) {
            datePart = number.substring(0, 6);
        } else if (number.length() == 12 || number.length() == 13) {
            datePart = number.substring(2, 8);
        } else {
            return false;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
        sdf.setLenient(false);
        try {
            sdf.parse(datePart);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    @Override
    public String getErrorMessage() {
        return "Födelsedatum delen av personnumret är ogiltigt.";
    }
}
