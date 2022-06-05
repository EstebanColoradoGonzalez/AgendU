package com.agendu.domain.service.student;

import com.agendu.domain.model.Student;
import com.agendu.domain.port.StudentRepository;
import com.agendu.domain.utilitarian.Message;
import com.agendu.domain.validator.ValidateObject;
import org.springframework.stereotype.Service;

@Service
public class ServiceSaveStudent
{
    private final StudentRepository studentRepository;

    public ServiceSaveStudent(StudentRepository studentRepository)
    {
        this.studentRepository = studentRepository;
    }

    public Long save(Student student)
    {
        checkStudentDoesNotExistsWithEmail(student.getEmail());

        return this.studentRepository.save(student);
    }

    private void checkStudentDoesNotExistsWithEmail(String email)
    {
        var studentSummary = this.studentRepository.getByEmail(email);

        if(!ValidateObject.isNull(studentSummary))
        {
            throw new IllegalArgumentException(Message.STUDENT_EXISTS_WITH_EMAIL);
        }
    }
}