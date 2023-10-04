package com.company;

public class LuhnValidityCheck implements ValidityCheck {

    @Override
    public boolean check(String number) {
        number = number.replaceAll("[^0-9]", "");

        if (number.length() == 12) {
            number = number.substring(2);
        }

        int sum = 0;
        boolean multiplyByTwo = true;

        for (int i = number.length() - 2; i >= 0; i--) {
            int n = Character.getNumericValue(number.charAt(i));

            if (multiplyByTwo) {
                n *= 2;
                if (n > 9) {
                    sum += (n / 10) + (n % 10);
                } else {
                    sum += n;
                }
            } else {
                sum += n;
            }
            multiplyByTwo = !multiplyByTwo;
        }

        int computedCheckDigit = (10 - (sum % 10)) % 10;
        int providedCheckDigit = Character.getNumericValue(number.charAt(number.length() - 1));

        return computedCheckDigit == providedCheckDigit;
    }

    @Override
    public String getErrorMessage() {
        return "Luhns algoritm kontroll misslyckades";
    }
}
