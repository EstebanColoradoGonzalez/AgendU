package com.agendu.infrastructure.adapter.repository.jpa;

import com.agendu.infrastructure.adapter.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDAO extends JpaRepository<RoleEntity, Long>
{

}