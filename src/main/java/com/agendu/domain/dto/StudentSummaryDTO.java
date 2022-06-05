package com.agendu.domain.dto;

import com.agendu.domain.model.StudentRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentSummaryDTO
{
    private Long id;
    private String name;
    private String email;
    private List<StudentRole> roles;
}