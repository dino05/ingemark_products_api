package com.ingemark.products.service.impl;

import com.ingemark.products.exceptions.ExchangeRateFetchException;
import com.ingemark.products.model.external.ExchangeRateResponse;
import com.ingemark.products.service.ExchangeRateService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class ExchangeRateServiceImpl implements ExchangeRateService {

    private static final Logger logger = LoggerFactory.getLogger(ExchangeRateService.class);

    private RestTemplate restTemplate;

    @Override
    public BigDecimal fetchExchangeRate() {
        String apiUrl = "https://api.hnb.hr/tecajn-eur/v3?valuta=USD";
        ResponseEntity<ExchangeRateResponse[]> response = restTemplate.getForEntity(apiUrl, ExchangeRateResponse[].class);

        logger.info("API Response: {}", response.getBody());

        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null && response.getBody().length > 0) {
            return new BigDecimal(response.getBody()[0].getSrednji_tecaj().replace(",", "."));
        } else {
            throw new ExchangeRateFetchException("Failed to fetch exchange rate from external API!");
        }
    }
}