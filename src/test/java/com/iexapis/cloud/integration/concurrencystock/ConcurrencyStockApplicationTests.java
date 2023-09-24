package com.iexapis.cloud.integration.concurrencystock;

import com.iexapis.cloud.integration.concurrencystock.application.port.persistence.QuoteNoSqlApi;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
@EnableAutoConfiguration(
        exclude = {
                DataSourceAutoConfiguration.class,
                MongoAutoConfiguration.class,
                MongoDataAutoConfiguration.class
        }
)
class ConcurrencyStockApplicationTests {

    @MockBean
    QuoteNoSqlApi quoteNoSqlApi;

    @Test
    void contextLoads() {
    }

}
