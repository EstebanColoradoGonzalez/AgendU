package com.agendu.domain.service.student;

import com.agendu.domain.dto.StudentSummaryDTO;
import com.agendu.domain.port.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class ServiceGetStudentById
{
    private final StudentRepository studentRepository;

    public ServiceGetStudentById(StudentRepository studentRepository)
    {
        this.studentRepository = studentRepository;
    }

    public StudentSummaryDTO getById(Long id)
    {
        return this.studentRepository.getById(id);
    }
}