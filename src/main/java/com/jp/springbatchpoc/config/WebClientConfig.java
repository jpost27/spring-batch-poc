package com.jp.springbatchpoc.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.http.codec.ClientCodecConfigurer;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

@Slf4j
@Configuration
public class WebClientConfig {

    private static final int bufferSizeKb = 20000;

    @Bean
    public WebClient webClient(ObjectMapper objectMapper) {
        return WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(
                        HttpClient.newConnection().compress(true)))
                .filters(exchangeFilterFunctions -> exchangeFilterFunctions.add(logRequest()))
                .exchangeStrategies(ExchangeStrategies.builder()
                        .codecs(configurer ->
                                configureClientCodecs(configurer, bufferSizeKb, objectMapper))
                        .build())
                .build();
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

    ExchangeFilterFunction logRequest() {
        return ExchangeFilterFunction.ofRequestProcessor(clientRequest -> {
            log.debug("Sending request to {}", clientRequest.url());
            return Mono.just(clientRequest);
        });
    }
}
