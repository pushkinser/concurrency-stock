package com.iexapis.cloud.integration.concurrencystock.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * QuotesModel
 *
 * @author Aleksey_Krivotulov
 * <p>
 * 22.09.2023
 */

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@RequiredArgsConstructor
public class QuotesModel {

    private String companyName;
    private String latestPrice;

}
