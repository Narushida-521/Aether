package com.nxd.aether.service;

import com.nxd.aether.enity.Student;
import com.nxd.aether.repo.StudentReactiveRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class StudentService {
    @Resource
    private StudentReactiveRepository studentReactiveRepository;

    public Flux<Student> getAllStudents() {
        return studentReactiveRepository.getAllStudents();
    }
}
