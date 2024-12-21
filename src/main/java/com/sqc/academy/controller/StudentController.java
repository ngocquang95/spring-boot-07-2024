package com.sqc.academy.controller;

import com.sqc.academy.dto.ApiResponse;
import com.sqc.academy.dto.page.PageResponse;
import com.sqc.academy.dto.student.StudentRequest;
import com.sqc.academy.dto.student.StudentResponse;
import com.sqc.academy.entity.Student;
import com.sqc.academy.exception.ApiException;
import com.sqc.academy.exception.ErrorCode;
import com.sqc.academy.mapper.IStudentMapper;
import com.sqc.academy.service.IStudentService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // json
@AllArgsConstructor // DI
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/students")
public class StudentController {
    IStudentService studentService;
    IStudentMapper studentMapper;

    @GetMapping
    public ResponseEntity<ApiResponse<PageResponse<StudentResponse>>> getStudents(@RequestParam(defaultValue = "") String name,
                                                                          @PageableDefault(size = 2, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok(ApiResponse.<PageResponse<StudentResponse>>builder()
                .data(new PageResponse<>(studentService.findAll(name, pageable).map(studentMapper::studentToStudentResponse)))
                .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<StudentResponse>> getByIdStudents(@PathVariable int id) {
        Student student = studentService.findById(id);

        if (student == null) {
            throw new ApiException(ErrorCode.STUDENT_NOT_EXIST);
        }

        return ResponseEntity.ok(
                ApiResponse.<StudentResponse>builder().data(studentMapper.studentToStudentResponse(student)).build());
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody StudentRequest studentRequest) {
        Student student = studentMapper.studentRequestToStudent(studentRequest);
        studentService.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiResponse.<StudentResponse>builder().data(studentMapper.studentToStudentResponse(student)).build());
    }
}
