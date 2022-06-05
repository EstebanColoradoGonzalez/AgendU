package com.agendu.application.service.student;

import com.agendu.application.dto.StudentDTO;
import com.agendu.domain.model.Student;
import com.agendu.domain.model.StudentRole;
import com.agendu.domain.service.student.ServiceSaveStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServiceApplicationSaveStudent
{
    @Autowired
    ServiceSaveStudent serviceSaveStudent;

    public Long save(StudentDTO student)
    {
        return this.serviceSaveStudent.save(assembleDomainFromDTO(student));
    }

    private Student assembleDomainFromDTO(StudentDTO student)
    {
        return Student.create(student.getId(), student.getName(), student.getEmail(), student.getPassword(), assembleStudentRoles());
    }

    private List<StudentRole> assembleStudentRoles()
    {
        return List.of(StudentRole.create(1L, "ROLE_REGISTERED"));
    }
}