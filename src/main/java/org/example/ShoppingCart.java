package org.example;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ShoppingCart {

    public static void main(String[] args) {
        System.out.println("Select a language ");
        System.out.println("1. Swedish");
        System.out.println("2. Finnish");
        System.out.println("3. English");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        Locale locale;
        switch (choice) {
            case 1:
                locale = new Locale("sv", "SE");
                break;
            case 2:
                locale = new Locale("fi", "FI");
                break;
            case 3:
                locale = new Locale("en", "US");
                break;
            default:
                System.out.println("Invalid language selection");
                locale = new Locale("en", "US");
                break;
        }

        ResourceBundle rb;
        try {
            rb = ResourceBundle.getBundle("MessagesBundle", locale);
        } catch (Exception e) {
            System.out.println("Invalid language is not in the list");
            rb = ResourceBundle.getBundle("MessagesBundle", new Locale("en", "US"));
        }

        System.out.print(rb.getString("itemCount"));
        int itemCount = scanner.nextInt();

        double totalCost = 0.0;
        for (int i = 1; i <= itemCount; i++) {
            System.out.print(MessageFormat.format(rb.getString("itemPrice"), i));
            double itemPrice = scanner.nextDouble();
            System.out.print(MessageFormat.format(rb.getString("itemQuantity"), i));
            double itemQuantity = scanner.nextDouble();
            totalCost += itemPrice * itemQuantity;
        }

        System.out.println(rb.getString("itemTotal") + totalCost);
    }
}