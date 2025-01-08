package com.example.Crizbuzz.dto.response;

import com.example.Crizbuzz.model.Enum.Speciality;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class PlayerResponse {

    String name;

    Speciality speciality;

}
