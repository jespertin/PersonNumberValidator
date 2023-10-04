package com.company;

public class CoordinationNumberCheck implements ValidityCheck {

    @Override
    public boolean check(String number) {
        String dayPart;

        if (number.length() == 10 || number.length() == 11) {
            dayPart = number.substring(4, 6);
        } else {
            dayPart = number.substring(6, 8);
        }

        int day = Integer.parseInt(dayPart);
        return day >= 61 && day <= 91;
    }

    @Override
    public String getErrorMessage() {
        return "Dagdelen av samordningsnumret är ogiltigt";
    }
}
