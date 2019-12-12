package com.shop.backend.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.shop.backend.util.Constants;

import java.util.HashMap;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyDto {
    @JsonProperty(Constants.BASE)
    private String base;
    @JsonProperty(Constants.RATES)
    private HashMap<String,String> rates;

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public HashMap<String, String> getRates() {
        return rates;
    }

    public void setRates(HashMap<String, String> rates) {
        this.rates = rates;
    }

    @Override
    public String toString() {
        return "CurrencyDto{" +
                "base='" + base + '\'' +
                ", rates=" + rates +
                '}';
    }
}
