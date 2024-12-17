package com.sqc.academy.dto.student;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentResponse {
    int id;
    String name;
    double score;
    String address;
    String clazzName;
}
