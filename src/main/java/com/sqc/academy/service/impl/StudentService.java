package com.sqc.academy.service.impl;

import com.sqc.academy.entity.Student;
import com.sqc.academy.repository.IStudentRepository;
import com.sqc.academy.service.IStudentService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentService implements IStudentService {
    IStudentRepository studentRepository;

    @Override
    public List<Student> findAll(String name) {
        return studentRepository.findByAttr(name, 9.6, 9.7);
    }

    @Override
    public Student findById(Integer id) {
        if (id == null) { // validate
            return null;
        }
        // sendmail
        return studentRepository.findById(id).get();
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }
}
