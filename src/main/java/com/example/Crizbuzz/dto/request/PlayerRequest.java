package com.example.Crizbuzz.dto.request;

import com.example.Crizbuzz.model.Enum.Gender;
import com.example.Crizbuzz.model.Enum.Speciality;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlayerRequest {

    String name;

    int age;

    Speciality speciality;

    Gender gender;

    String email;

}
