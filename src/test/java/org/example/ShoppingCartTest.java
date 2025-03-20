package org.example;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShoppingCartTest {

    @Test
    void testTotalCostCalculation() {
        String input = "3\n2\n10.0\n2\n20.0\n1\n30.0\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Locale locale = new Locale("en", "US");
        ResourceBundle rb = ResourceBundle.getBundle("MessagesBundle", locale);

        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(locale);

        int itemCount = scanner.nextInt();

        double totalCost = 0.0;
        for (int i = 1; i <= itemCount; i++) {
            double itemPrice = scanner.nextDouble();
            double itemQuantity = scanner.nextDouble();
            totalCost += itemPrice * itemQuantity;
        }

        assertEquals(90.0, totalCost, 0.01);
    }
}