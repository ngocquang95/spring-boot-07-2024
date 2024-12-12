package com.sqc.academy.service;

import com.sqc.academy.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService {
    Page<Student> findAll(String name, Pageable pageable);

    Student findById(Integer id);

    Student save(Student student);
}
