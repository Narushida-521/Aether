package com.nxd.aether.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public Flux<String> hello() throws InterruptedException {
        List<String> stringList = List.of("Hello", "World", "today", "is", "2025", "09", "01");
        Flux<String> stringFlux = Flux.fromIterable(stringList).delayElements(Duration.ofSeconds(1)).log();
        return stringFlux;
    }
}
