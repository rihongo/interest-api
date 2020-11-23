package com.rihongo.service;

import reactor.core.publisher.Mono;

public interface ProductRemoteService {
    String getProductInfo(String productId);
}
