package com.rihongo.api;

import com.rihongo.service.ProductRemoteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/displays")
public class DisplayController {

    private final ProductRemoteService productRemoteService;

    public DisplayController(ProductRemoteService productRemoteService) {
        this.productRemoteService = productRemoteService;
    }

    @GetMapping(path = "{displayId}")
    public Mono getDisplayDetail(@PathVariable String displayId) {

        String productInfo = productRemoteService.getProductInfo(displayId);
        return Mono.just(String.format("[display id = %s at %s %s]", displayId, System.currentTimeMillis(), productInfo));
    }
}
