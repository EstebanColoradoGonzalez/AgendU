package com.agendu.infrastructure.service.assembler;

import com.agendu.domain.model.StudentRole;
import com.agendu.infrastructure.adapter.entity.StudentRoleEntity;

import java.util.List;

public interface StudentRoleAssemblerInfrastructure extends AssemblerInfrastructure<StudentRole, StudentRoleEntity>
{
    List<StudentRole> assembleDomainsFromEntities(List<StudentRoleEntity> entities);
    List<StudentRoleEntity> assembleEntitiesFromDomains(List<StudentRole> domains);
}