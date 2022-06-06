package com.agendu.application.service.student;

import com.agendu.domain.dto.StudentSummaryDTO;
import com.agendu.domain.service.student.ServiceGetStudentById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceApplicationGetStudentById
{
    @Autowired
    ServiceGetStudentById serviceGetStudentById;

    public StudentSummaryDTO getById(Long id)
    {
        return this.serviceGetStudentById.getById(id);
    }
}