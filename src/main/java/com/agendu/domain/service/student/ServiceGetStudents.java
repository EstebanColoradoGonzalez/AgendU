package com.agendu.domain.service.student;

import com.agendu.domain.dto.StudentSummaryDTO;
import com.agendu.domain.port.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.List;

@Service
public class ServiceGetStudents
{
    private final StudentRepository studentRepository;

    public ServiceGetStudents(StudentRepository studentRepository)
    {
        this.studentRepository = studentRepository;
    }

    public List<StudentSummaryDTO> getAll()
    {
        var students = new java.util.ArrayList<>(this.studentRepository.getAll());

        students.sort(Comparator.comparingLong(StudentSummaryDTO::getId));

        return students;
    }
}