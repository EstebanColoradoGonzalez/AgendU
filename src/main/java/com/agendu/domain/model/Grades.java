package com.agendu.domain.model;

import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Grades
{
    private final Long id;
    private double definitive;
    private final Course course;
    private final Grade firstPartial;
    private final Grade secondPartial;

    private Grades(Long id, Course course, Grade firstPartial, Grade secondPartial)
    {
        this.id = id;
        setDefinitive(course, firstPartial, secondPartial);
        this.course = course;
        this.firstPartial = firstPartial;
        this.secondPartial = secondPartial;
    }
    public static Grades create(Long id, Course course, Grade firstPartial, Grade secondPartial)
    {
        return new Grades(id, course, firstPartial, secondPartial);
    }

    private void setDefinitive(Course course, Grade firstPartial, Grade secondPartial)
    {
        List<Double> gradesAccumulated = new ArrayList<>();
        double total = 0;

        gradesAccumulated.add(course.getDefinitive() * course.getPercentage());
        gradesAccumulated.add(firstPartial.getValue() * firstPartial.getPercentage());
        gradesAccumulated.add(secondPartial.getValue() * secondPartial.getPercentage());

        for (Double gradeAccumulated : gradesAccumulated)
        {
            total += gradeAccumulated;
        }

        this.definitive = Math.round(total*10.0)/10.0;
    }
}