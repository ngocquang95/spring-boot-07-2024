package com.sqc.academy.repository.impl;

import com.sqc.academy.model.Student;
import com.sqc.academy.repository.IStudentRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class StudentRepository implements IStudentRepository {
    private final List<Student> students = new ArrayList<>(
            Arrays.asList(
                    new Student(1, "Hồ Văn Trung", 9.6),
                    new Student(2, "Ngoc Mai", 9.8),
                    new Student(3, "Phương", 9.7)
            )
    );

    public List<Student> findAll() {
        return students;
    }

    public Student findById(Integer id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public Student save(Student student) {
        student.setId((int) (Math.random() * 100000000));
        students.add(student);
        return student;
    }
}
