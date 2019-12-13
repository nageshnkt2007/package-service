package com.shop.backend.controller;

import com.shop.backend.service.CurrencyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "/currency", produces = MediaType.APPLICATION_JSON_VALUE)
public class CurrencyController {

    public static final Logger LOG = LoggerFactory.getLogger(CurrencyController.class);

    @Autowired
    private CurrencyService currencyService;

    @GetMapping("/rates")
    public ResponseEntity<?> getCurrencyDetails(@RequestParam(name = "base",required = false) String currency){
        return ResponseEntity.status(HttpStatus.OK).body(currencyService.getCurrencyRate(currency));
    }
}
