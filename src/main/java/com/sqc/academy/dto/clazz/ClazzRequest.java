package com.sqc.academy.dto.clazz;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClazzRequest {
    @NotNull(message = "Bat buoc phai chon lop")
    Integer id;
    String name;
}
