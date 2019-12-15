package com.shop.backend.service;

import com.shop.backend.dto.CurrencyDto;

public interface CurrencyService {

    /**
     * @param currency .
     * @return Current Currency details .
     */
    CurrencyDto getCurrencyRate(String currency);

    /**
     * @param currency
     * @return factor for currency calculation .
     */
    Float getCurrencyFactor(String currency);
}
