package com.nxd.aether.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
@Component
public class HelloController {
    public Mono<ServerResponse> naxida(ServerRequest request) {
        System.out.println(request);
        String date=request.pathVariable("date");
        System.out.println(date);
        Flux<String> flux = Flux.just("na", "xi", "da", "2025", "09", "05").delayElements(
                Duration.ofSeconds(2)
        );
        return ServerResponse.ok().body(flux, String.class);
    }
}
