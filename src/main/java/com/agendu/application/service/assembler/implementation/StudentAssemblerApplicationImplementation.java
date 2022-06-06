package com.agendu.application.service.assembler.implementation;

import com.agendu.application.dto.StudentDTO;
import com.agendu.application.service.assembler.StudentAssemblerApplication;
import com.agendu.domain.model.Student;
import static com.agendu.application.service.assembler.implementation.StudentRoleAssemblerApplicationImplementation.getStudentRoleAssembler;

public class StudentAssemblerApplicationImplementation implements StudentAssemblerApplication
{
    private static final StudentAssemblerApplication INSTANCE = new StudentAssemblerApplicationImplementation();

    private StudentAssemblerApplicationImplementation()
    {

    }

    public static StudentAssemblerApplication getStudentAssembler()
    {
        return INSTANCE;
    }

    @Override
    public Student assembleDomainFromDTO(StudentDTO dto)
    {
        return Student.create(dto.getId(), dto.getName(), dto.getEmail(), dto.getPassword(), getStudentRoleAssembler().assembleDomainsFromDTOs(dto.getRoles()));
    }

    @Override
    public StudentDTO assembleDTOFromDomain(Student domain)
    {
        return new StudentDTO(domain.getId(), domain.getName(), domain.getEmail(), domain.getPassword(), getStudentRoleAssembler().assembleDTOsFromDomains(domain.getRoles()));
    }
}