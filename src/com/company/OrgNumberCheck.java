package com.company;

public class OrgNumberCheck implements ValidityCheck {

    @Override
    public boolean check(String number) {
        String monthPart;

        if (number.length() == 10 || number.length() == 11) {
            monthPart = number.substring(2, 4);
        } else if (number.length() == 12 || number.length() == 13) {
            monthPart = number.substring(4, 6);
        } else {
            return false;
        }

        int middle = Integer.parseInt(monthPart);
        return middle >= 20;
    }

    @Override
    public String getErrorMessage() {
        return "Mittersta delen av organisationsnumret är ogiltigt.";
    }
}
