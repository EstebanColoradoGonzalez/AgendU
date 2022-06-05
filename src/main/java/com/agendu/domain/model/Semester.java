package com.agendu.domain.model;

import com.agendu.domain.utilitarian.Message;
import com.agendu.domain.validator.ValidateString;
import lombok.Getter;

import java.util.List;

@Getter
public class Semester
{
    private final Long id;
    private String name;
    private final List<Subject> subjects;
    private final Schedule schedule;

    private Semester(Long id, String name, List<Subject> subjects, Schedule schedule)
    {
        this.id = id;
        setName(name);
        this.subjects = subjects;
        this.schedule = schedule;
    }

    public static Semester create(Long id, String name, List<Subject> subjects, Schedule schedule)
    {
        return new Semester(id, name, subjects, schedule);
    }

    private void setName(String name)
    {
        if(ValidateString.isStringEmpty(name))
        {
            throw new IllegalArgumentException(Message.SEMESTER_NAME_CHECK_STRING_EMPTY);
        }

        if(!ValidateString.isLengthValid(name, 1, 7))
        {
            throw new IllegalArgumentException(Message.SEMESTER_NAME_CHECK_LENGTH_VALID);
        }

        if(!ValidateString.stringContainsOnlyLettersAndSpaces(name))
        {
            throw new IllegalArgumentException(Message.SEMESTER_NAME_CHECK_PATTERN);
        }

        this.name = name;
    }
}