package com.detailedcurrency;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.math.BigDecimal;
import java.net.URL;
import java.util.HashMap;

public class ParseJsonResult {
    private static String json;

    private Boolean success;
    private URL terms;
    private URL privacy;
    private Long timestamp;
    private String base;
    @JsonAlias(value = {"quotes", "rates"})
    private HashMap<String, BigDecimal> rates;


    public ParseJsonResult() {
    }

    public ParseJsonResult(String json) {
        ParseJsonResult.json = json;
    }


    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public URL getTerms() {
        return terms;
    }

    public void setTerms(URL terms) {
        this.terms = terms;
    }

    public URL getPrivacy() {
        return privacy;
    }

    public void setPrivacy(URL privacy) {
        this.privacy = privacy;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public HashMap<String, BigDecimal> getRates() {
        return rates;
    }

    public void setRates(HashMap<String, BigDecimal> rates) {
        this.rates = rates;
    }
}