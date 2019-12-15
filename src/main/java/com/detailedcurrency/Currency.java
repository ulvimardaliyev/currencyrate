package com.detailedcurrency;

//Valyuta class
public class Currency {
    public static Relationship relationshipWithTwoCurrency(String firstCurrency, String secondCurrency) {
        Relationship rs = null;
        for (int i = 0; i < Constant.getUrls().length; i++) {
            try {
                rs = Connection.createConnection(i, Constant.getUrls()[i], firstCurrency, secondCurrency);
            } catch (Exception e) {
                continue;
            }
        }
        return rs;
    }
}
