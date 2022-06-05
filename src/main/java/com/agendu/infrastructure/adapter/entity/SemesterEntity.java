package com.agendu.infrastructure.adapter.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SemesterEntity
{
    private Long id;
    private String name;
    private List<SubjectEntity> subjects;
    private ScheduleEntity schedules;
}