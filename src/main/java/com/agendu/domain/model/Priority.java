package com.agendu.domain.model;

import com.agendu.domain.utilitarian.Message;
import com.agendu.domain.validator.ValidateNumber;
import com.agendu.domain.validator.ValidateString;
import lombok.Getter;

@Getter
public class Priority
{
    private final Long id;
    private int position;
    private String name;

    private Priority(Long id, int position, String name)
    {
        this.id = id;
        setPosition(position);
        setName(name);
    }

    public static Priority create(Long id, int position, String name)
    {
        return new Priority(id, position, name);
    }

    private void setPosition(int position)
    {
        if(!ValidateNumber.isNumberGreater(position, 0))
        {
            throw new IllegalArgumentException(Message.PRIORITY_POSITION_CHECK_VALUE);
        }

        this.position = position;
    }

    private void setName(String name)
    {
        if(ValidateString.isStringEmpty(name))
        {
            throw new IllegalArgumentException(Message.PRIORITY_NAME_CHECK_STRING_EMPTY);
        }

        if(!ValidateString.isLengthValid(name, 1, 50))
        {
            throw new IllegalArgumentException(Message.PRIORITY_NAME_CHECK_LENGTH_VALID);
        }

        if(!ValidateString.stringContainsOnlyLettersAndSpaces(name))
        {
            throw new IllegalArgumentException(Message.PRIORITY_NAME_CHECK_PATTERN);
        }

        this.name = name;
    }
}