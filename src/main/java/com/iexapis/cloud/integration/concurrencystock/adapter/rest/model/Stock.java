package com.iexapis.cloud.integration.concurrencystock.adapter.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@RequiredArgsConstructor
public class Stock {

    private String symbol;
}
