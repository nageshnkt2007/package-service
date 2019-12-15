package com.shop.backend.controller;

import com.shop.backend.service.CurrencyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * CurrencyController takes currency and get current rates from a
 * public API for all the diffrent currencies .
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "/currency", produces = MediaType.APPLICATION_JSON_VALUE)
public class CurrencyController {

    public static final Logger LOG = LoggerFactory.getLogger(CurrencyController.class);

    /**
     * Currency service which handles business logic related
     * currency.
     */
    @Autowired
    private CurrencyService currencyService;

    /**
     * CurrencyDto consisting of base package object which specifies
     * current base package and Hashmap<String,String> of all the
     *  currencies with their respective rate factor.
     * @param currency .
     * @return Returns CurrencyDto
     *
     */
    @GetMapping("/rates")
    public ResponseEntity<?> getCurrencyDetails(@RequestParam(name = "base",required = false) String currency){
        return ResponseEntity.status(HttpStatus.OK).body(currencyService.getCurrencyRate(currency));
    }
}
