package com.agendu.domain.service.student;

import com.agendu.domain.dto.StudentSummaryDTO;
import com.agendu.domain.port.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class ServiceGetStudentByEmail
{
    private final StudentRepository studentRepository;

    public ServiceGetStudentByEmail(StudentRepository studentRepository)
    {
        this.studentRepository = studentRepository;
    }

    public StudentSummaryDTO getByEmail(String email)
    {
        return this.studentRepository.getByEmail(email);
    }
}