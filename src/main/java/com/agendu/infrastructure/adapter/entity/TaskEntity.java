package com.agendu.infrastructure.adapter.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskEntity
{
    private Long id;
    private LocalDate date;
    private String value;
    private PriorityEntity priority;
}