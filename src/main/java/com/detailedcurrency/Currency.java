package com.detailedcurrency;

//Valyuta class
public class Currency {
    public static Relationship relationshipWithTwoCurrency(String firstCurrency, String secondCurrency) {
        Relationship rs = null;
        for (int i = 0; i < Constant.URLS.length; i++) {
            try {
                rs = Connection.createConnection(i, Constant.URLS[i], firstCurrency, secondCurrency);
                break;
            } catch (Exception e) {
                continue;
            }
        }
        return rs;
    }
}
