package com.agendu.application.service.student;

import com.agendu.domain.service.student.ServiceDeleteUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceApplicationDeleteUser
{
    @Autowired
    ServiceDeleteUser serviceDeleteUser;

    public void delete(Long id)
    {
        this.serviceDeleteUser.delete(id);
    }
}
