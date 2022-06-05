package com.agendu.domain.model;

import com.agendu.domain.utilitarian.Message;
import com.agendu.domain.validator.ValidateString;
import lombok.Getter;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;

@Getter
public class Subject
{
    private final Long id;
    private String day;
    private final LocalTime startTime;
    private final LocalTime endTime;
    private final Grades grades;
    private List<Task> tasks;

    private Subject(Long id, String day, LocalTime startTime, LocalTime endTime, Grades grades, List<Task> tasks)
    {
        this.id = id;
        setDay(day);
        this.startTime = startTime;
        this.endTime = endTime;
        this.grades = grades;
        setTasks(tasks);
    }

    public static Subject create(Long id, String day, LocalTime startTime, LocalTime endTime, Grades grades, List<Task> tasks)
    {
        return new Subject(id, day, startTime, endTime, grades, tasks);
    }

    private void setDay(String day)
    {
        if(ValidateString.isStringEmpty(day))
        {
            throw new IllegalArgumentException(Message.SUBJECT_DAY_CHECK_STRING_EMPTY);
        }

        if(!ValidateString.isLengthValid(day, 1, 9))
        {
            throw new IllegalArgumentException(Message.SUBJECT_DAY_CHECK_LENGTH_VALID);
        }

        if(!ValidateString.stringDay(day))
        {
            throw new IllegalArgumentException(Message.SUBJECT_DAY_CHECK_PATTERN);
        }

        this.day = day;
    }

    public void setTasks(List<Task> tasks)
    {
        tasks.sort(Comparator.comparingInt(task -> task.getPriority().getPosition()));

        this.tasks = tasks;
    }
}