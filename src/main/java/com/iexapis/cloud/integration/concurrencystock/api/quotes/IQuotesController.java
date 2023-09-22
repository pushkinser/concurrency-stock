package com.iexapis.cloud.integration.concurrencystock.api.quotes;

import com.iexapis.cloud.integration.concurrencystock.model.QuotesModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

/**
 * StockController
 *
 * @author Aleksey_Krivotulov
 * <p>
 * 22.09.2023
 */
@Controller
public class IQuotesController implements QuotesController {

    private final RestTemplate restTemplate;
    private final String token;

    private final String url;

    private final String urlSafety;

    private final String stockNamePlaceholder;

    public IQuotesController(RestTemplate restTemplate,
                             @Value("${app.integration.api.iexcloud.url.quotes}") String url,
                             @Value("${app.integration.api.iexcloud.url.stockNameKey}") String stockNamePlaceholder,
                             @Value("${app.integration.api.iexcloud.token}") String token) {
        this.restTemplate = restTemplate;
        this.url = url;
        this.token = token;
        this.stockNamePlaceholder = stockNamePlaceholder;
        this.urlSafety = url + "?token=" + token;
    }

    @Override
    public QuotesModel getQuotesByStocks(String stockName) {
        String completeUrl = urlSafety.replace(stockNamePlaceholder, stockName);
        ResponseEntity<QuotesModel> quotesModelResponse = restTemplate
                .getForEntity(completeUrl, QuotesModel.class);
        return quotesModelResponse.getBody();
    }

}
