package com.detailedcurrency;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Connection {

    private static StringBuilder response = new StringBuilder();

    public static Relationship createConnection(int count, String url,
                                                String first, String second) {
        Relationship rs = null;
        ParseJsonResult parseJsonResult;

        switch (count) {
            case 0:
                if (establishConnectionWithURL(url) != null) {
                    parseJsonResult = new ParseJsonResult(response.toString());
                    System.out.println("Inside case 0 after parseJsonResult OBJ");
                    rs = new Relationship(parseJsonResult, first, second);
                    response.delete(0, response.length());
                    return rs.parsingg();
                }

                break;
            case 1:
                if (establishConnectionWithURL(url) != null) {
                    parseJsonResult = new ParseJsonResult(response.toString());
                    rs = new Relationship(parseJsonResult, first, second);
                    response.delete(0, response.length());
                    return rs.parsingg();
                }

                break;
            default:
                System.out.println("No available urls");
                break;
        }
        return rs;
    }


    private static String establishConnectionWithURL(String url) {
        try {
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
                System.out.println("JSON String Result " + response.toString());
                return response.toString();
            } else {
                System.out.println("GET NOT WORKED");
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
}

