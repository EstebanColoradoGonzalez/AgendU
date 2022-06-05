package com.agendu.infrastructure.adapter.repository.jpa;

import com.agendu.infrastructure.adapter.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDAO extends JpaRepository<StudentEntity, Long>
{
    StudentEntity findByEmail(String email);
    StudentEntity findByEmailAndPassword(String email, String password);
}