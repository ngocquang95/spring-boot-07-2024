package com.sqc.academy.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Clazz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;

    @OneToMany(mappedBy = "clazz")
    @JsonIgnoreProperties("clazz")
    List<Student> students;
}

// API - findAllClazz
// bao nhieu cau query?
// query 1: Get All Class (id=1, id = 2)
// query 2: findStudentByClazzId = 1
// query 3: findStudentByClazzId = 2

// có 2 lop
