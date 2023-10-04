package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Validator personNumberValidator = new Validator();
        personNumberValidator.addCheck(new FormatCheck());
        personNumberValidator.addCheck(new PersonNumberDateCheck());
        personNumberValidator.addCheck(new LuhnValidityCheck());

        Validator coordinationNumberValidator = new Validator();
        coordinationNumberValidator.addCheck(new FormatCheck());
        coordinationNumberValidator.addCheck(new CoordinationNumberCheck());
        coordinationNumberValidator.addCheck(new LuhnValidityCheck());

        Validator orgNumberValidator = new Validator();
        orgNumberValidator.addCheck(new FormatCheck());
        orgNumberValidator.addCheck(new OrgNumberCheck());
        orgNumberValidator.addCheck(new LuhnValidityCheck());

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nVälj typ av nummer att validera:");
            System.out.println("1. Personnummer");
            System.out.println("2. Samordningsnummer");
            System.out.println("3. Organisationsnummer");
            System.out.println("4. Avsluta");

            String choice = scanner.nextLine();
            if (choice.equals("4")) {
                break;
            }

            System.out.println("Ange nummer för validering (backa tillbaks med en tom rad):");

            while (true) {
                String input = scanner.nextLine();
                if (input.isBlank()) {
                    break;
                }

                switch (choice) {
                    case "1":
                        if (personNumberValidator.validate(input)) {
                            System.out.println(input + " är ett giltigt personnummer");
                        } else {
                            System.out.println(input + " är ett ogiltigt personnummer");
                        }
                        break;

                    case "2":
                        if (coordinationNumberValidator.validate(input)) {
                            System.out.println(input + " är ett giltigt samordningsnummer.");
                        } else {
                            System.out.println(input + " är ogiltigt som samordningsnummer.");
                        }
                        break;

                    case "3":
                        if (orgNumberValidator.validate(input)) {
                            System.out.println(input + " är ett giltigt organisationsnummer.");
                        } else {
                            System.out.println(input + " är ogiltigt som organisationsnummer.");
                        }
                        break;

                    default:
                        System.out.println("Ogiltigt val. Försök igen.");
                }
            }

        }
        scanner.close();
    }
}