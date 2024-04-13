package com.jp.springbatchpoc.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ClientCodecConfigurer;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class GraphQLClientConfig {

    @Value("${almanac.api.base-url}")
    private String almanacBaseUrl;

    @Value("${almanac.api.username}")
    private String almanacUsername;

    @Value("${almanac.api.password}")
    private String almanacPassword;

    private final ObjectMapper clientObjectMapper;

    public GraphQLClientConfig() {
        this.clientObjectMapper = JsonMapper.builder()
                .findAndAddModules()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .addModule(new Jdk8Module())
                .build();
    }

    @Bean
    public HttpGraphQlClient almanacGraphQlClient() {
        WebClient webClient = WebClient.builder()
                .baseUrl(almanacBaseUrl + "/graphql")
                .exchangeStrategies(ExchangeStrategies.builder()
                        .codecs(configurer -> configureClientCodecs(configurer, 2048, clientObjectMapper))
                        .build())
                .build();
        HttpGraphQlClient graphQlClient = HttpGraphQlClient.builder(webClient)
                .headers(headers -> headers.setBasicAuth(almanacUsername, almanacPassword))
                .build();
        return graphQlClient;
    }

    private void configureClientCodecs(ClientCodecConfigurer configurer, int bufferSizeKB, ObjectMapper objectMapper) {
        configurer
                .defaultCodecs()
                .jackson2JsonEncoder(new Jackson2JsonEncoder(objectMapper, MediaType.APPLICATION_JSON));
        configurer
                .defaultCodecs()
                .jackson2JsonDecoder(new Jackson2JsonDecoder(objectMapper, MediaType.APPLICATION_JSON));
        configurer.defaultCodecs().maxInMemorySize(bufferSizeKB * 1024);
    }
}
