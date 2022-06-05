package com.agendu.infrastructure.adapter.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GradesEntity
{
    private Long id;
    private double definitive;
    private CourseEntity course;
    private GradeEntity firstPartial;
    private GradeEntity secondPartial;
}