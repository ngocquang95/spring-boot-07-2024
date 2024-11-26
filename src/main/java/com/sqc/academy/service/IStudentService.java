package com.sqc.academy.service;

import com.sqc.academy.entity.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll(String name);

    Student findById(Integer id);

    Student save(Student student);
}
