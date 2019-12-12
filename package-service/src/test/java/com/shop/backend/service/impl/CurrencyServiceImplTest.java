package com.shop.backend.service.impl;

import com.shop.backend.dto.CurrencyDto;
import com.shop.backend.service.CurrencyService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CurrencyServiceImplTest {
    @Autowired
    private CurrencyService currencyService = new CurrencyServiceImpl();
    public static final String USD ="USD";
    public static final String currencyRate = "1.0";

    @DisplayName("Test accuracy of currency service")
    @Test
    void getCurrencyRate() {
        CurrencyDto currencyDto = currencyService.getCurrencyRate(USD);
        assertEquals(currencyDto.getBase(),USD);
        assertEquals(currencyDto.getRates().get(USD),currencyRate);
    }
}
