package com.nxd.aether.routers;

import com.nxd.aether.controller.HelloController;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.*;


@Configuration
public class RoutersConfig {
    @Resource
    public HelloController helloController;

    @Bean
    public RouterFunction<ServerResponse> routerConfig() {
        return RouterFunctions.route(
                RequestPredicates.GET("/naxida/{date}"),
                helloController::naxida
        ).andRoute(RequestPredicates.GET("/student"), helloController::student);
        /*
         * If you want to define multiple routes, you need to chain them together instead of returning them separately.
         * The RouterFunctions API provides andRoute() methods to achieve this.
         * */
    }
}
