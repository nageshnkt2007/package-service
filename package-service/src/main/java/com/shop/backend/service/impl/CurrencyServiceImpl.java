package com.shop.backend.service.impl;

import com.shop.backend.dto.CurrencyDto;
import com.shop.backend.service.CurrencyService;
import com.shop.backend.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.Arrays;

/**
 * This class fetches Currency details from exchangeratesapi.io based on currency provided .
 */
@Service("currencyService")
public class CurrencyServiceImpl implements CurrencyService {
    public static final Logger LOG = LoggerFactory.getLogger(CurrencyServiceImpl.class);


    /**
     * @param currency .
     * @return Cache response for different Currencies from Currency source .
     */
    @Cacheable(value = "defaultSource", key = "#currency")
    public CurrencyDto getCurrencyRate(String currency) {
        CurrencyDto response = getCurrencyDetails(currency);
        LOG.info("Caching response for currency {} = {} ",currency,response);
        return response;
    }

    /**
     * @param currency .
     * @return CurrencyDto from currency source .
     */
    private CurrencyDto getCurrencyDetails(String currency) {
        LOG.info("getting currency details for currency  {} ",currency);
        currency = !StringUtils.isEmpty(currency) ? Constants.USD : currency;
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(Constants.URL_CURRENCY).queryParam(Constants.BASE, currency);
        CurrencyDto currencyDto = null;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        ResponseEntity<CurrencyDto> result = restTemplate.exchange(uriComponentsBuilder.toUriString(), HttpMethod.GET, entity, CurrencyDto.class);
        if(result.getStatusCode().equals(HttpStatus.OK)){
            currencyDto = result.getBody();
        }
        return currencyDto;
    }
}
