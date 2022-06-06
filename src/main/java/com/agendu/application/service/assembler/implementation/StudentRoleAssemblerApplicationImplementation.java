package com.agendu.application.service.assembler.implementation;

import com.agendu.application.dto.StudentRoleDTO;
import com.agendu.application.service.assembler.StudentRoleAssemblerApplication;
import com.agendu.domain.model.StudentRole;
import java.util.List;

public class StudentRoleAssemblerApplicationImplementation implements StudentRoleAssemblerApplication
{
    private static final StudentRoleAssemblerApplication INSTANCE = new StudentRoleAssemblerApplicationImplementation();

    private StudentRoleAssemblerApplicationImplementation()
    {

    }

    public static StudentRoleAssemblerApplication getStudentRoleAssembler()
    {
        return INSTANCE;
    }

    @Override
    public StudentRole assembleDomainFromDTO(StudentRoleDTO dto)
    {
        return StudentRole.create(dto.getId(), dto.getName());
    }

    @Override
    public StudentRoleDTO assembleDTOFromDomain(StudentRole domain)
    {
        return new StudentRoleDTO(domain.getId(), domain.getName());
    }

    @Override
    public List<StudentRole> assembleDomainsFromDTOs(List<StudentRoleDTO> dtos)
    {
        return dtos.stream().map(getStudentRoleAssembler()::assembleDomainFromDTO).toList();
    }

    @Override
    public List<StudentRoleDTO> assembleDTOsFromDomains(List<StudentRole> domains)
    {
        return domains.stream().map(getStudentRoleAssembler()::assembleDTOFromDomain).toList();
    }
}