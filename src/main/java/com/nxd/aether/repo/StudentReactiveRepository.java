package com.nxd.aether.repo;

import com.nxd.aether.enity.Student;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface StudentReactiveRepository extends
        ReactiveCrudRepository<Student, Integer> {
    @Query("select s.lastName,s.firstName from student s")
    public Flux<Student> getAllStudents();
}
