package com.company;

public interface ValidityCheck {

    boolean check(String number);

    String getErrorMessage();
}
