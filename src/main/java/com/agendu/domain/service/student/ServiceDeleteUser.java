package com.agendu.domain.service.student;

import com.agendu.domain.port.StudentRepository;
import com.agendu.domain.utilitarian.Message;
import com.agendu.domain.validator.ValidateObject;
import org.springframework.stereotype.Service;

@Service
public class ServiceDeleteUser
{
    private final StudentRepository studentRepository;

    public ServiceDeleteUser(StudentRepository studentRepository)
    {
        this.studentRepository = studentRepository;
    }

    public void delete(Long id)
    {
        if(ValidateObject.isNull(this.studentRepository.getById(id)))
        {
            throw new IllegalArgumentException(Message.STUDENT_DOES_NOT_EXISTS_WITH_ID);
        }

        this.studentRepository.delete(id);
    }
}
