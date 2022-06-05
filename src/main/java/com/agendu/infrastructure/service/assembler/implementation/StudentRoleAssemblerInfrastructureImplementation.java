package com.agendu.infrastructure.service.assembler.implementation;

import com.agendu.domain.model.StudentRole;
import com.agendu.infrastructure.adapter.entity.RoleEntity;
import com.agendu.infrastructure.adapter.entity.StudentRoleEntity;
import com.agendu.infrastructure.service.assembler.StudentRoleAssemblerInfrastructure;
import java.util.List;

public class StudentRoleAssemblerInfrastructureImplementation implements StudentRoleAssemblerInfrastructure
{
    private static final StudentRoleAssemblerInfrastructure INSTANCE = new StudentRoleAssemblerInfrastructureImplementation();

    private StudentRoleAssemblerInfrastructureImplementation()
    {

    }

    public static StudentRoleAssemblerInfrastructure getStudentRoleAssembler()
    {
        return INSTANCE;
    }

    @Override
    public StudentRole assembleDomainFromEntity(StudentRoleEntity entity)
    {
        return StudentRole.create(entity.getId(), entity.getRole().getName());
    }

    @Override
    public StudentRoleEntity assembleEntityFromDomain(StudentRole domain)
    {
        return new StudentRoleEntity(domain.getId(), new RoleEntity(domain.getId(), domain.getName()));
    }

    @Override
    public List<StudentRole> assembleDomainsFromEntities(List<StudentRoleEntity> entities)
    {
        return entities.stream().map(getStudentRoleAssembler()::assembleDomainFromEntity).toList();
    }

    @Override
    public List<StudentRoleEntity> assembleEntitiesFromDomains(List<StudentRole> domains)
    {
        return domains.stream().map(getStudentRoleAssembler()::assembleEntityFromDomain).toList();
    }
}