package com.agendu.domain.model;

import com.agendu.domain.utilitarian.Message;
import com.agendu.domain.validator.ValidateString;
import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Day
{
    private final Long id;
    private String name;
    private List<Subject> subjects;

    private Day(Long id, String name, List<Subject> subjects)
    {
        this.id = id;
        setName(name);
        setSubjects(name, subjects);
    }

    public static Day create(Long id, String name, List<Subject> subjects)
    {
        return new Day(id, name, subjects);
    }

    public void setName(String name)
    {
        if(ValidateString.isStringEmpty(name))
        {
            throw new IllegalArgumentException(Message.DAY_NAME_CHECK_STRING_EMPTY);
        }

        if(!ValidateString.isLengthValid(name, 1, 9))
        {
            throw new IllegalArgumentException(Message.DAY_NAME_CHECK_LENGTH_VALID);
        }

        if(!ValidateString.stringDay(name))
        {
            throw new IllegalArgumentException(Message.DAY_NAME_CHECK_PATTERN);
        }

        this.name = name;
    }

    private void setSubjects(String name, List<Subject> subjects)
    {
        List<Subject> filterSubjects = new ArrayList<>();

        subjects.forEach(subject ->
        {
            if(subject.getDay().equals(name))
            {
                filterSubjects.add(subject);
            }
        });

        this.subjects = filterSubjects;
    }
}