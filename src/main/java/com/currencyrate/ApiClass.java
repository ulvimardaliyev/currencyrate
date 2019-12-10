package com.currencyrate;

public class ApiClass {
    private String latest = "https://api.exchangeratesapi.io/latest";
    private String historical = "https://api.exchangeratesapi.io/2010-01-12";//change the date in this string
    private String baseCurrency = "https://api.exchangeratesapi.io/latest?base=USD";//change the base to EUR etc instead of USD
    //change symbols to anything you want in currency, TRY,USD
    private String specificExchangeRate = "https://api.exchangeratesapi.io/latest?symbols=USD,GBP";


    public String getLatest() {
        return latest;
    }

    public String getHistorical() {
        return historical;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public String getSpecificExchangeRate() {
        return specificExchangeRate;
    }
}
