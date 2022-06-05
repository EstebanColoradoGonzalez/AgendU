package com.agendu.domain.model;

import com.agendu.domain.utilitarian.Message;
import com.agendu.domain.validator.ValidateString;
import lombok.Getter;
import java.time.LocalDate;

@Getter
public class Task
{
    private final Long id;
    private final LocalDate date;
    private String value;
    private final Priority priority;

    private Task(Long id, LocalDate date, String value, Priority priority)
    {
        this.id = id;
        this.date = date;
        setValue(value);
        this.priority = priority;
    }

    public static Task create(Long id, LocalDate date, String value, Priority priority)
    {
        return new Task(id, date, value, priority);
    }

    private void setValue(String value)
    {
        if(ValidateString.isStringEmpty(value))
        {
            throw new IllegalArgumentException(Message.TASK_VALUE_CHECK_STRING_EMPTY);
        }

        if(!ValidateString.isLengthValid(value, 1, 100))
        {
            throw new IllegalArgumentException(Message.TASK_VALUE_CHECK_LENGTH_VALID);
        }

        this.value = value;
    }
}