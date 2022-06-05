package com.agendu.domain.model;

import com.agendu.domain.utilitarian.Message;
import com.agendu.domain.validator.ValidateNumber;
import com.agendu.domain.validator.ValidateString;
import lombok.Getter;

@Getter
public class Grade
{
    private final Long id;
    private String description;
    private double value;
    private double percentage;

    private Grade(Long id, String description, double value, double percentage)
    {
        this.id = id;
        setDescription(description);
        setValue(value);
        setPercentage(percentage);
    }

    public static Grade create(Long id, String description, double value, double percentage)
    {
        return new Grade(id, description, value, percentage);
    }

    private void setDescription(String description)
    {
        if(ValidateString.isStringEmpty(description))
        {
            throw new IllegalArgumentException(Message.GRADE_DESCRIPTION_CHECK_STRING_EMPTY);
        }

        if(!ValidateString.isLengthValid(description, 1, 50))
        {
            throw new IllegalArgumentException(Message.GRADE_DESCRIPTION_CHECK_LENGTH_VALID);
        }

        this.description = description;
    }

    private void setValue(double value)
    {
        if(!ValidateNumber.isNumberGreaterThanOrEqual(value, 0))
        {
            throw new IllegalArgumentException(Message.GRADE_VALUE_CHECK_VALUE);
        }

        this.value = value;
    }

    private void setPercentage(double percentage)
    {
        if(!ValidateNumber.isNumberGreaterThanOrEqual(percentage, 0))
        {
            throw new IllegalArgumentException(Message.GRADE_PERCENTAGE_CHECK_VALUE);
        }

        this.percentage = percentage;
    }
}