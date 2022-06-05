package com.agendu.domain.utilitarian;

public class Message
{
    private Message()
    {

    }

    public static final String STUDENT_ROLE_NAME_CHECK_STRING_EMPTY = "The name of a Role cannot be empty.";
    public static final String STUDENT_ROLE_NAME_CHECK_LENGTH_VALID = "The name of a Role must contain a length between 1 and 15 characters.";
    public static final String STUDENT_ROLE_NAME_CHECK_PATTERN = "The name of a Role must contain only letters and spaces.";

    public static final String PRIORITY_POSITION_CHECK_VALUE = "The position of a Priority must be grater than 0.";
    public static final String PRIORITY_NAME_CHECK_STRING_EMPTY = "The name of a Priority cannot be empty.";
    public static final String PRIORITY_NAME_CHECK_LENGTH_VALID = "The name of a Priority must contain a length between 1 and 50 characters.";
    public static final String PRIORITY_NAME_CHECK_PATTERN = "The name of a Priority must contain only letters and spaces.";

    public static final String GRADE_DESCRIPTION_CHECK_STRING_EMPTY = "The description of a Grade cannot be empty.";
    public static final String GRADE_DESCRIPTION_CHECK_LENGTH_VALID = "The description of a Grade must contain a length between 1 and 100 characters.";
    public static final String GRADE_VALUE_CHECK_VALUE = "The value of a Grade must be grater than or equal 0.0.";
    public static final String GRADE_PERCENTAGE_CHECK_VALUE = "The value of a Grade must be grater than or equal 0.0.";

    public static final String STUDENT_NAME_CHECK_STRING_EMPTY = "The name of a Student cannot be empty.";
    public static final String STUDENT_NAME_CHECK_LENGTH_VALID = "The name of a Student must contain a length between 1 and 50 characters.";
    public static final String STUDENT_NAME_CHECK_PATTERN = "The name of a Student must contain only letters and spaces.";
    public static final String STUDENT_EMAIL_CHECK_STRING_EMPTY = "The email of a Student cannot be empty.";
    public static final String STUDENT_EMAIL_CHECK_LENGTH_VALID = "The email of a Student must contain a length between 1 and 100 characters.";
    public static final String STUDENT_EMAIL_CHECK_PATTERN = "The email of a Student doesn't meet the pattern: user@example.com";
    public static final String STUDENT_SECRETWORD_CHECK_STRING_EMPTY = "The password of a Student cannot be empty.";
    public static final String STUDENT_SECRETWORD_CHECK_LENGTH_VALID = "The password of a Student must contain a length between 1 and 255 characters.";
    public static final String STUDENT_SECRETWORD_CHECK_PATTERN = "The password of a Student must have minimum a capital letter a number and a letter";

    public static final String TASK_VALUE_CHECK_STRING_EMPTY = "The value of a Task cannot be empty.";
    public static final String TASK_VALUE_CHECK_LENGTH_VALID = "The value of a Task must contain a length between 1 and 100 characters.";

    public static final String SUBJECT_DAY_CHECK_STRING_EMPTY = "The day of a Subject cannot be empty.";
    public static final String SUBJECT_DAY_CHECK_LENGTH_VALID = "The day of a Subject must contain a length between 1 and 9 characters.";
    public static final String SUBJECT_DAY_CHECK_PATTERN = "The day of a Subject must contain only letters and spaces.";

    public static final String DAY_NAME_CHECK_STRING_EMPTY = "The name of a Day cannot be empty.";
    public static final String DAY_NAME_CHECK_LENGTH_VALID = "The name of a Day must contain a length between 1 and 9 characters.";
    public static final String DAY_NAME_CHECK_PATTERN = "The name of a Day must contain only letters and spaces.";

    public static final String SEMESTER_NAME_CHECK_STRING_EMPTY = "The name of a Semester cannot be empty.";
    public static final String SEMESTER_NAME_CHECK_LENGTH_VALID = "The name of a Semester must contain a length between 1 and 100 characters.";
    public static final String SEMESTER_NAME_CHECK_PATTERN = "The name of a Semester must contain only letters and spaces.";

    public static final String STUDENT_EXISTS_WITH_EMAIL = "There is already a student with that email";

    public static final String STUDENT_CREATION_SUCCESSFUL = "The student was saved successful";
}