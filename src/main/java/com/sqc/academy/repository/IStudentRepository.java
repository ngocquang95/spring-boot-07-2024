package com.sqc.academy.repository;

import com.sqc.academy.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IStudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByNameContainingAndScoreBetween(String name,
                                                      Double fromScore,
                                                      Double toScore);

    @Query(value = """
            SELECT *
            FROM student
            WHERE name LIKE concat('%', :name, '%')
              AND score BETWEEN :fromScore AND :toScore;
            """, nativeQuery = true)
    List<Student> findByAttr(@Param("name") String name,
                             @Param("fromScore") Double fromScore,
                             @Param("toScore") Double toScore);

    @Query(value = """
            FROM Student
            WHERE name LIKE concat('%', :name, '%')
              AND score BETWEEN :fromScore AND :toScore;
            """)
    List<Student> findByAttrHQL(@Param("name") String name,
                                @Param("fromScore") Double fromScore,
                                @Param("toScore") Double toScore);
}