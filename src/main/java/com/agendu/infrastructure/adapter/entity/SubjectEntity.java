package com.agendu.infrastructure.adapter.entity;

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
public class SubjectEntity
{
    private Long id;
    private String day;
    private LocalTime startTime;
    private LocalTime endTime;
    private GradesEntity grades;
    private List<TaskEntity> tasks;
}