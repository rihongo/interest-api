package com.rihongo.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class ProductRemoteServiceImpl implements ProductRemoteService {

    private static final String url = "http://product/products/";

    private WebClient.Builder webClientBuilder;

    public ProductRemoteServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    @Override
    @HystrixCommand(commandKey = "productInfo", fallbackMethod = "getProductInfoFallback")
    public String getProductInfo(String productId) {
        WebClient webClient = webClientBuilder.build();
        return webClient.get().uri(url + productId).exchange()
                .flatMap(s -> s.bodyToMono(String.class)).block();

    }

    public String getProductInfoFallback(String productId, Throwable t) {
        return "[This Product is sold out]";
    }
}
