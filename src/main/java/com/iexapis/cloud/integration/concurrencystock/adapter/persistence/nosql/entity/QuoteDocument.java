package com.iexapis.cloud.integration.concurrencystock.adapter.persistence.nosql.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

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
@EqualsAndHashCode(of = "companyName")
@Document(collection = "quoteDocument")
public class QuoteDocument {

    @Id
    private UUID companyId;

    @Field("companyName")
    private String companyName;
    @Field("latestPrice")
    private String latestPrice;

}
