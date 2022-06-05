package com.agendu.domain.port;

import com.agendu.domain.dto.StudentSummaryDTO;
import com.agendu.domain.model.Student;
import java.util.List;

public interface StudentRepository
{
    List<StudentSummaryDTO> getAll();
    StudentSummaryDTO getById(Long id);
    StudentSummaryDTO getByEmail(String email);
    Long save(Student student);
    Long modify(Long id, Student student);
    void delete(Long id);
    boolean exists(Long id);
    boolean login(String email, String password);
}