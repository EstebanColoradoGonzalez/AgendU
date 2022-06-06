package com.agendu.application.service.assembler;

import com.agendu.application.dto.StudentDTO;
import com.agendu.domain.dto.StudentSummaryDTO;
import com.agendu.domain.model.Student;
import com.agendu.infrastructure.adapter.entity.StudentEntity;

public interface StudentAssemblerApplication extends AssemblerApplication<Student, StudentDTO>
{

}