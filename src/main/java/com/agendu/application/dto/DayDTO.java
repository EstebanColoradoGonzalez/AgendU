package com.agendu.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DayDTO
{
    private Long id;
    private String name;
    private List<SubjectDTO> subjects;
}