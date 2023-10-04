package com.company;

import java.util.ArrayList;
import java.util.List;

public class Validator {

    private List<ValidityCheck> checks;

    public Validator() {
        this.checks = new ArrayList<>();
    }

    public void addCheck(ValidityCheck check) {
        this.checks.add(check);
    }

    public boolean validate(String number) {
        for (ValidityCheck check : checks) {
            if (!check.check(number)) {
                System.out.println(check.getErrorMessage());
                return false;
            }
        }
        return true;
    }
}
