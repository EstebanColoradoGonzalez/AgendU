package com.agendu.infrastructure.service.assembler.implementation;

import com.agendu.domain.dto.StudentSummaryDTO;
import com.agendu.domain.model.Student;
import com.agendu.infrastructure.adapter.entity.StudentEntity;
import com.agendu.infrastructure.service.assembler.StudentAssemblerInfrastructure;
import static com.agendu.infrastructure.service.assembler.implementation.StudentRoleAssemblerInfrastructureImplementation.getStudentRoleAssembler;

public class StudentAssemblerInfrastructureImplementation implements StudentAssemblerInfrastructure
{
    private static final StudentAssemblerInfrastructure INSTANCE = new StudentAssemblerInfrastructureImplementation();

    private StudentAssemblerInfrastructureImplementation()
    {

    }

    public static StudentAssemblerInfrastructure getStudentAssembler()
    {
        return INSTANCE;
    }

    @Override
    public Student assembleDomainFromEntity(StudentEntity entity)
    {
        return Student.create(entity.getId(), entity.getName(), entity.getEmail(), entity.getPassword(), getStudentRoleAssembler().assembleDomainsFromEntities(entity.getRoles()));
    }

    @Override
    public StudentEntity assembleEntityFromDomain(Student domain)
    {
        return new StudentEntity(domain.getId(), domain.getName(), domain.getEmail(), domain.getPassword(), getStudentRoleAssembler().assembleEntitiesFromDomains(domain.getRoles()));
    }

    @Override
    public StudentSummaryDTO assembleSummaryDTOFromEntity(StudentEntity entity)
    {
        return new StudentSummaryDTO(entity.getId(), entity.getName(), entity.getEmail(), getStudentRoleAssembler().assembleDomainsFromEntities(entity.getRoles()));
    }
}