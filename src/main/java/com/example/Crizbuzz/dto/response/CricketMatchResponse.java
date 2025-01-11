package com.example.Crizbuzz.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CricketMatchResponse {

    String title;

    String venue;

    Date matchDate;

    Time matchTime;

    List<TeamResponse> teams;
}
