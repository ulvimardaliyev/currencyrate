package com.detailedcurrency;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter your country currency");
        String currency1 = scanner.next().toUpperCase();
        System.out.println("Please, enter the desired currency");
        String currency2 = scanner.next().toUpperCase();
        System.out.println("Result with your country currency");
        Relationship rs1 = Currency.relationshipWithTwoCurrency(currency1, currency2);
        System.out.println("Result with desired currency");
        Relationship rs2 = Currency.relationshipWithTwoCurrency(currency2, currency1);

    }
}
/**
 * Hesablama
 * 1 USD = 0.899281 EUR
 * X = 1 EUR
 *
 * X = 1*1/0.899281 = 1.111999475
 *
 * 1 USD = 1.7025 AZN
 * 1.112 USD (Yeni EURO) = Y
 * Y=1.7025*1.112 = 1.89318
 * */

/*
* 1 USD  = 5.808204 TRY
* X USD = 1 TRY
* X= 1/5.808204=0.172170 USD
*
* 1 USD = 1.7025 AZN
* 0.172170 USD = Y AZN
* Y = 1.7025*0.172170
* */