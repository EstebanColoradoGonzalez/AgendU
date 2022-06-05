package com.agendu.domain.model;

import lombok.Getter;
import java.util.List;

@Getter
public class Schedule
{
    private final Long id;
    private final List<Day> days;

    private Schedule(Long id, List<Day> days)
    {
        this.id = id;
        this.days = days;
    }

    public static Schedule create(Long id, List<Day> days)
    {
        return new Schedule(id, days);
    }
}