package com.agendu.application.service.student;

import com.agendu.application.dto.StudentDTO;
import com.agendu.domain.service.student.ServiceUpdateStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import static com.agendu.application.service.assembler.implementation.StudentAssemblerApplicationImplementation.getStudentAssembler;

@Component
public class ServiceApplicationUpdateStudent
{
    @Autowired
    ServiceUpdateStudent serviceUpdateStudent;

    public Long update(Long id, StudentDTO student)
    {
        student.setId(id);

        return this.serviceUpdateStudent.update(getStudentAssembler().assembleDomainFromDTO(student));
    }
}