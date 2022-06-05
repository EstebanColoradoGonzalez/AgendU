package com.agendu.domain.model;

import com.agendu.domain.utilitarian.Message;
import com.agendu.domain.validator.ValidateString;
import lombok.Getter;
import java.util.List;

@Getter
public class Student
{
    private final Long id;
    private String name;
    private String email;
    private String password;
    private final List<StudentRole> roles;

    private Student(Long id, String name, String email, String password, List<StudentRole> roles)
    {
        this.id = id;
        setName(name);
        setEmail(email);
        setPassword(password);
        this.roles = roles;
    }

    public static Student create(Long id, String name, String email, String password, List<StudentRole> roles)
    {
        return new Student(id, name, email, password, roles);
    }

    private void setName(String name)
    {
        if(ValidateString.isStringEmpty(name))
        {
            throw new IllegalArgumentException(Message.STUDENT_NAME_CHECK_STRING_EMPTY);
        }

        if(!ValidateString.isLengthValid(name, 1, 50))
        {
            throw new IllegalArgumentException(Message.STUDENT_NAME_CHECK_LENGTH_VALID);
        }

        if(!ValidateString.stringContainsOnlyLettersAndSpaces(name))
        {
            throw new IllegalArgumentException(Message.STUDENT_NAME_CHECK_PATTERN);
        }

        this.name = name;
    }

    private void setEmail(String email)
    {
        if(ValidateString.isStringEmpty(name))
        {
            throw new IllegalArgumentException(Message.STUDENT_EMAIL_CHECK_STRING_EMPTY);
        }

        if(!ValidateString.isLengthValid(name, 1, 100))
        {
            throw new IllegalArgumentException(Message.STUDENT_EMAIL_CHECK_LENGTH_VALID);
        }

        if(!ValidateString.stringContainsOnlyLettersAndSpaces(name))
        {
            throw new IllegalArgumentException(Message.STUDENT_EMAIL_CHECK_PATTERN);
        }

        this.email = email;
    }

    private void setPassword(String password)
    {
        if(ValidateString.isStringEmpty(name))
        {
            throw new IllegalArgumentException(Message.STUDENT_SECRETWORD_CHECK_STRING_EMPTY);
        }

        if(!ValidateString.isLengthValid(name, 1, 255))
        {
            throw new IllegalArgumentException(Message.STUDENT_SECRETWORD_CHECK_LENGTH_VALID);
        }

        if(!ValidateString.stringContainsOnlyLettersAndSpaces(name))
        {
            throw new IllegalArgumentException(Message.STUDENT_SECRETWORD_CHECK_PATTERN);
        }

        this.password = password;
    }
}