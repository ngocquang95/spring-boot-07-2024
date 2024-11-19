package com.sqc.academy.repository.impl;

import com.sqc.academy.model.Student;
import com.sqc.academy.repository.IStudentRepository;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository implements IStudentRepository {
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();

        // Lấy data từ DB
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection()
                    .prepareStatement("select id, name, score from student");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                students.add(Student.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .score(resultSet.getDouble("score"))
                        .build());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return students;
    }

    public Student findById(Integer id) {
        // Lấy data từ DB
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection()
                    .prepareStatement("select id, name, score from student where id = ?");
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return Student.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .score(resultSet.getDouble("score"))
                        .build();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    public Student save(Student student) {
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection()
                    .prepareStatement("insert into student (name, score) value (?, ?)");
            preparedStatement.setString(1, student.getName());
            preparedStatement.setDouble(2, student.getScore());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return student;
    }
}
