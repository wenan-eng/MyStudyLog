package com.wenan.eldemo.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 描述：    EsConfig
 */
@Configuration
public class EsConfig {

    @Bean
    public RestHighLevelClient restClient() {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("127.0.0.1", 9300, "http"),
                        new HttpHost("127.0.0.1", 9200, "http")
                )
        );
        return client;
    }
}
