package com.nxd.aether.controller;

import com.nxd.aether.enity.Student;
import com.nxd.aether.service.StudentService;
import jakarta.annotation.Resource;
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
        String date = request.pathVariable("date");
        System.out.println(date);
        Flux<String> flux = Flux.just("na", "xi", "da", "2025", "09", "05").delayElements(
                Duration.ofSeconds(2)
        );
        return ServerResponse.ok().body(flux, String.class);
    }

    @Resource
    private StudentService studentService;

    public Mono<ServerResponse> student(ServerRequest request) {
        Flux<Student> allStudents = studentService.getAllStudents().delayElements(Duration.ofSeconds(3));
        return ServerResponse.ok().contentType(MediaType.TEXT_EVENT_STREAM).body(allStudents, Student.class);
    }
}
