package com.nxd.aether.routers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Configuration
public class RoutersConfig {
    @Bean
    public RouterFunction<ServerResponse> routerConfig() {
//        RequestPredicate predicate, HandlerFunction<T> handlerFunction
        return RouterFunctions.route(
                RequestPredicates.GET("/naxida"),
                request -> {
                    Flux<String> flux = Flux.just("na", "xi", "da", "2025", "09", "05").delayElements(
                            Duration.ofSeconds(5)
                    );
                    return ServerResponse.ok().contentType(MediaType.TEXT_EVENT_STREAM).body(flux, String.class);
                }
        );
    }
}
