package com.agendu.application.service.assembler;

import com.agendu.application.dto.StudentRoleDTO;
import com.agendu.domain.model.StudentRole;
import com.agendu.infrastructure.adapter.entity.StudentRoleEntity;

import java.util.List;

public interface StudentRoleAssemblerApplication extends AssemblerApplication<StudentRole, StudentRoleDTO>
{
    List<StudentRole> assembleDomainsFromDTOs(List<StudentRoleDTO> dtos);
    List<StudentRoleDTO> assembleDTOsFromDomains(List<StudentRole> domains);
}