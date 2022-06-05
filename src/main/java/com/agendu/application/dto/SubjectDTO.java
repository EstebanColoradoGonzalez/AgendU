package com.agendu.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDTO
{
    private Long id;
    private String day;
    private LocalTime startTime;
    private LocalTime endTime;
    private GradesDTO grades;
    private List<TaskDTO> tasks;
}