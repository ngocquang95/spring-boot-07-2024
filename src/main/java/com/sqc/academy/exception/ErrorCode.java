package com.sqc.academy.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum ErrorCode {
    STUDENT_NOT_EXIST(40401, "Student is not exists!", HttpStatus.NOT_FOUND),
    TEACHER_NOT_EXIST(40402, "Teacher is not exists!", HttpStatus.NOT_FOUND),
    UNAUTHORIZED(40101, "Username or password is incorrect!", HttpStatus.UNAUTHORIZED);

    Integer code;
    String message;
    HttpStatus status;
}
