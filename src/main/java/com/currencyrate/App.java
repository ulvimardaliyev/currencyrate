package com.currencyrate;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String url = "https://api.exchangeratesapi.io/latest";
        System.out.println("Which currency do you want to be based on");
        String isBasedOnThisCurrency = scanner.next();

        if (!isBasedOnThisCurrency.isEmpty()) {
            url = url.concat("?base=" + isBasedOnThisCurrency);
        }
        StringBuilder response = new StringBuilder();
        try {
            URL urlCon = new URL(url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) urlCon.openConnection();

            httpURLConnection.setRequestMethod("GET");
            //System.out.println(url);
            int responseCode = httpURLConnection.getResponseCode();
            //System.out.println(responseCode);
            String inline;

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(httpURLConnection.getInputStream()));
                while ((inline = in.readLine()) != null) {
                    response.append(inline);
                }
                in.close();
                System.out.println("JSON " + response.toString());
            } else{
                System.out.println("Bad Connection");
            }
        } catch (MalformedURLException c) {
            System.out.println("Please, check your internet");
        } catch (IOException i) {
            System.out.println("Input is not valid");
        }
        JSONObject jsonObject = new JSONObject(response.toString()).getJSONObject("rates");

        System.out.println("Please, select your currency");
        String myCurrency = scanner.next().toUpperCase();
        System.out.println("Please, select desired currency");
        String desiredCurrency = scanner.next().toUpperCase();
        double myCurrencyNum = jsonObject.getDouble(myCurrency);
        double desiredCurrencyNum = jsonObject.getDouble(desiredCurrency);
        System.out.println((myCurrencyNum / desiredCurrencyNum) * 100);

    }
}
