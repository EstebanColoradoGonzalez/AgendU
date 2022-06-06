package com.agendu.domain.service.student;

import com.agendu.domain.model.Student;
import com.agendu.domain.port.StudentRepository;
import com.agendu.domain.utilitarian.Message;
import com.agendu.domain.validator.ValidateObject;
import org.springframework.stereotype.Service;
import java.util.Objects;

@Service
public class ServiceUpdateStudent
{
    private final StudentRepository studentRepository;

    public ServiceUpdateStudent(StudentRepository studentRepository)
    {
        this.studentRepository = studentRepository;
    }

    public Long update(Student student)
    {
        checkStudentDoesNotExistsWithEmailAndId(student.getEmail(), student.getId());

        return this.studentRepository.update(student);
    }

    private void checkStudentDoesNotExistsWithEmailAndId(String email, Long id)
    {
        var studentSummary = this.studentRepository.getByEmail(email);

        if(!ValidateObject.isNull(studentSummary) && !Objects.equals(studentSummary.getId(), id))
        {
            throw new IllegalArgumentException(Message.STUDENT_EXISTS_WITH_EMAIL);
        }
    }
}