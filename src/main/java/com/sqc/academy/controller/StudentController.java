package com.sqc.academy.controller;

import com.sqc.academy.dto.ApiResponse;
import com.sqc.academy.exception.ApiException;
import com.sqc.academy.exception.ErrorCode;
import com.sqc.academy.entity.Student;
import com.sqc.academy.service.IStudentService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // json
@AllArgsConstructor // DI
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/students")
public class StudentController {
    IStudentService studentService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Student>>> getStudents(@RequestParam(defaultValue = "") String name) {
        return ResponseEntity.ok(ApiResponse.<List<Student>>builder().data(studentService.findAll(name)).build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Student>> getByIdStudents(@PathVariable int id) {
        Student student = studentService.findById(id);

        if (student == null) {
            throw new ApiException(ErrorCode.STUDENT_NOT_EXIST);
        }

        return ResponseEntity.ok(
                ApiResponse.<Student>builder().data(student).build());
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Student>> save(@RequestBody Student student) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiResponse.<Student>builder().data(studentService.save(student)).build());
    }
}
