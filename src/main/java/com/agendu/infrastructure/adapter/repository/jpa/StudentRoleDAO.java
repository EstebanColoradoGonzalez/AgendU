package com.agendu.infrastructure.adapter.repository.jpa;

import com.agendu.infrastructure.adapter.entity.StudentRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRoleDAO extends JpaRepository<StudentRoleEntity, Long>
{

}