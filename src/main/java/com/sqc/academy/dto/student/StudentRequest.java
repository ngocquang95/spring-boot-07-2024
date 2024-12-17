package com.sqc.academy.dto.student;

import com.sqc.academy.dto.clazz.ClazzRequest;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentRequest {
    String name;
    double score;
    String address;
    ClazzRequest clazz;
}
