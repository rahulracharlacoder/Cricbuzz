package com.example.Crizbuzz.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class StatsResponse {

    int runs;

    int wickets;

    PlayerResponse player;
}
