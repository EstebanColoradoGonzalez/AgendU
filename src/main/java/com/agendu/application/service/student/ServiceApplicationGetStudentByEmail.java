package com.agendu.application.service.student;

import com.agendu.domain.dto.StudentSummaryDTO;
import com.agendu.domain.service.student.ServiceGetStudentByEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceApplicationGetStudentByEmail
{
    @Autowired
    ServiceGetStudentByEmail serviceGetStudentByEmail;

    public StudentSummaryDTO getByEmail(String email)
    {
        return this.serviceGetStudentByEmail.getByEmail(email);
    }
}