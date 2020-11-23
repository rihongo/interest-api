package com.rihongo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "product")
public interface FeignProductService {

    @RequestMapping(path = "/products/{productId}")
    String getProductInfo(@PathVariable String productId);
}
