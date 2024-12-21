package com.sqc.academy.dto.student;

import com.sqc.academy.dto.clazz.ClazzRequest;
import com.sqc.academy.validation.DobConstraint;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentRequest {
    @NotBlank(message = "Ten khong duoc de trong")
    @Pattern(regexp = "[a-zA-ZÀ-ỹ ]+", message = "Ten phai dung dinh dang")
    String name;

    double score;

    @NotBlank(message = "Dia chi khong duoc de trong")
    String address;

    @NotNull(message = "Class khong duoc de trong")
    @Valid
    ClazzRequest clazz;

    @NotNull(message = "Ngay sinh khong duoc de trong")
    @DobConstraint(min = 18, message = "Phai tren 18 tuoi")
    LocalDate dateOfBirth;
}
