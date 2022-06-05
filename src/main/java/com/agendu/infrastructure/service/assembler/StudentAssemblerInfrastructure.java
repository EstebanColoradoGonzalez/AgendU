package com.agendu.infrastructure.service.assembler;

import com.agendu.domain.dto.StudentSummaryDTO;
import com.agendu.domain.model.Student;
import com.agendu.infrastructure.adapter.entity.StudentEntity;

public interface StudentAssemblerInfrastructure extends AssemblerInfrastructure<Student, StudentEntity>
{
    StudentSummaryDTO assembleSummaryDTOFromEntity(StudentEntity entity);
}