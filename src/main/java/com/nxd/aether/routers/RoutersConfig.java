package com.nxd.aether.routers;

import com.nxd.aether.controller.HelloController;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Configuration
public class RoutersConfig {
    @Resource
    public HelloController helloController;

    @Bean
    public RouterFunction<ServerResponse> routerConfig() {
        return RouterFunctions.route(
                RequestPredicates.GET("/naxida/{date}"),
                helloController::naxida);
    }
}
