package com.iexapis.cloud.integration.concurrencystock.application.port.persistence.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

/**
 * QuoteDocument
 *
 * @author Aleksey_Krivotulov
 * <p>
 * 24.09.2023
 */
@Data
@Builder
@Document(collation = "quote")
public class QuoteDocument {

    @Id
    private UUID companyId;

    private String companyName;
    private String latestPrice;

}
