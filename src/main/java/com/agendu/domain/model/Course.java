package com.agendu.domain.model;

import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Course
{
    private final Long id;
    private final double percentage;
    private double definitive;
    private final List<Grade> grades;

    private Course(Long id, double percentage, List<Grade> grades)
    {
        this.id = id;
        this.percentage = percentage;
        setDefinitive(grades);
        this.grades = grades;
    }

    public static Course create(Long id, double percentage, List<Grade> grades)
    {
        return new Course(id, percentage, grades);
    }

    private void setDefinitive(List<Grade> grades)
    {
        List<Double> gradesAccumulated = new ArrayList<>();
        double total = 0;

        grades.forEach(grade ->
        {
            gradesAccumulated.add(grade.getValue() * grade.getPercentage());
        });

        for (Double gradeAccumulated : gradesAccumulated)
        {
            total += gradeAccumulated;
        }

        this.definitive = Math.round(total*10.0)/10.0;
    }
}