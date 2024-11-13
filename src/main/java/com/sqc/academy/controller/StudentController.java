package com.sqc.academy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private static final Logger log = LoggerFactory.getLogger(StudentController.class);
    private final List<Student> students = new ArrayList<>(
            Arrays.asList(
                    new Student(1, "Hồ Văn Trung", 9.6),
                    new Student(2, "Ngoc Mai", 9.8),
                    new Student(3, "Phương", 9.7)
            )
    );

    // @RequestMapping(value = "/students", method = RequestMethod.GET)
    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {
        return ResponseEntity.ok(students);
    }

    // http://localhost:8080/students/4
    @GetMapping("/{id}")
    public ResponseEntity<Student> getByIdStudents(@PathVariable int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                // return ResponseEntity.status(HttpStatus.OK).body(student);
                return ResponseEntity.ok(student);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    public ResponseEntity<Student> save(@RequestBody Student student) {
        student.setId((int) (Math.random() * 100000000));
        students.add(student);

        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }
}
