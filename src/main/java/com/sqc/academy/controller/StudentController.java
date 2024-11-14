package com.sqc.academy.controller;

import com.sqc.academy.dto.ApiResponse;
import com.sqc.academy.exception.ApiException;
import com.sqc.academy.exception.ErrorCode;
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

    @GetMapping
    public ResponseEntity<ApiResponse<List<Student>>> getStudents() {
        return ResponseEntity.ok(ApiResponse.<List<Student>>builder().data(students).build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Student>> getByIdStudents(@PathVariable int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return ResponseEntity.ok(
                        ApiResponse.<Student>builder().data(student).build());
            }
        }

        throw new ApiException(ErrorCode.STUDENT_NOT_EXIST);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Student>> save(@RequestBody Student student) {
        student.setId((int) (Math.random() * 100000000));
        students.add(student);

        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiResponse.<Student>builder().data(student).build());
    }
}
