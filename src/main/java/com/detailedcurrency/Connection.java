package com.detailedcurrency;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Connection {


    public static Relationship createConnection(int count, String url,
                                                String first, String second) throws Exception {

        Relationship rs = null;
        ParseJsonResult jsonResult;

        switch (count) {
            case 0:
                jsonResult = new ParseJsonResult(establishConnectionWithURL(url));
                rs = Relationship.parsingg(count, jsonResult, first, second);
                break;
            case 1:
                jsonResult = new ParseJsonResult(establishConnectionWithURL(url));
                rs = Relationship.parsingg(count, jsonResult, first, second);
                break;
            case 3:
                jsonResult = new ParseJsonResult(establishConnectionWithURL(url, first, second));
                rs = Relationship.parsingg(count, jsonResult, first, second);
                break;
            default:
                System.out.println("No available urls");
                break;
        }
        return rs;
    }


    private static String establishConnectionWithURL(String url) throws Exception {
        StringBuilder response = new StringBuilder();
        String result = null;
        URL urlCon = new URL(url);
        HttpURLConnection httpURLConnection = (HttpURLConnection) urlCon.openConnection();
        httpURLConnection.setRequestMethod("GET");
        int responseCode = httpURLConnection.getResponseCode();
        String inline;
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(httpURLConnection.getInputStream()));
            while ((inline = in.readLine()) != null) {
                response.append(inline);
            }
            in.close();
            result = response.toString();
            response.delete(0, response.length());

        } else {
            new Throwable("GET NOT WORKED");

        }
        return result;
    }

    private static String establishConnectionWithURL(String url, String val1, String val2) throws Exception {
        StringBuilder response = new StringBuilder();
        String result = null;
        URL urlCon = (true) ? new URL(url + "&currencies=" + val1 + "," + val2)
                : new URL(url + "&symbols=" + val1 + "," + val2);
        HttpURLConnection httpURLConnection = (HttpURLConnection) urlCon.openConnection();
        httpURLConnection.setRequestMethod("GET");
        int responseCode = httpURLConnection.getResponseCode();
        String inline;
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(httpURLConnection.getInputStream()));
            while ((inline = in.readLine()) != null) {
                response.append(inline);
            }
            in.close();
            result = response.toString();
            response.delete(0, response.length());

        } else {
            new Throwable("GET NOT WORKED");

        }
        return result;
    }
}

