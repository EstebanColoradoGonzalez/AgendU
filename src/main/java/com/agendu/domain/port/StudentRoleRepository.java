package com.agendu.domain.port;

import com.agendu.domain.model.StudentRole;

public interface StudentRoleRepository
{
    StudentRole getById(Long id);
    Long save(StudentRole studentRole);
    Long modify(Long id, StudentRole studentRole);
    void delete(Long id);
    boolean exists(Long id);
}