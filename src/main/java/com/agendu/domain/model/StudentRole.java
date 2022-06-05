package com.agendu.domain.model;

import com.agendu.domain.utilitarian.Message;
import com.agendu.domain.validator.ValidateString;
import lombok.Getter;

@Getter
public class StudentRole
{
    private final Long id;
    private String name;

    private StudentRole(Long id, String name)
    {
        this.id = id;
        setName(name);
    }

    public static StudentRole create(Long id, String name)
    {
        return new StudentRole(id, name);
    }

    private void setName(String name)
    {
        if(ValidateString.isStringEmpty(name))
        {
            throw new IllegalArgumentException(Message.STUDENT_ROLE_NAME_CHECK_STRING_EMPTY);
        }

        if(!ValidateString.isLengthValid(name, 1, 15))
        {
            throw new IllegalArgumentException(Message.STUDENT_ROLE_NAME_CHECK_LENGTH_VALID);
        }

        if(!ValidateString.isStringAlphanumeric(name))
        {
            throw new IllegalArgumentException(Message.STUDENT_ROLE_NAME_CHECK_PATTERN);
        }

        this.name = name;
    }
}