package com.agendu.application.service.student;

import com.agendu.domain.dto.StudentSummaryDTO;
import com.agendu.domain.service.student.ServiceGetStudents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ServiceApplicationGetStudents
{
    @Autowired
    ServiceGetStudents serviceGetStudents;

    public List<StudentSummaryDTO> getAll()
    {
        return this.serviceGetStudents.getAll();
    }
}