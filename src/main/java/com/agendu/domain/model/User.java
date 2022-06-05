package com.agendu.domain.model;

import lombok.Getter;

@Getter
public class User
{
    private final Long id;
    private final Semester semester;
    private final Long studentId;

    private User(Long id, Semester semester, Long studentId)
    {
        this.id = id;
        this.semester = semester;
        this.studentId = studentId;
    }

    public static User create(Long id, Semester semester, Long studentId)
    {
        return new User(id, semester, studentId);
    }
}