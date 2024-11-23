package com.sqc.academy.repository;

import com.sqc.academy.entity.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();

    Student findById(Integer id);

    Student save(Student student);
}