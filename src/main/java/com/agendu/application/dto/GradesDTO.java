package com.agendu.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GradesDTO
{
    private Long id;
    private double definitive;
    private CourseDTO course;
    private GradeDTO firstPartial;
    private GradeDTO secondPartial;
}