package com.company;

public class FormatCheck implements ValidityCheck {

    @Override
    public boolean check(String number) {
        if (number.length() == 10 || number.matches("^\\d{6}[-+]\\d{4}$") || number.matches("^\\d{8}[-+]?\\d{4}$")) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getErrorMessage() {
        return "Personnumrets längd eller format är ogiltigt";
    }
}
