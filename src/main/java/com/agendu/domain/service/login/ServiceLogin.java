package com.agendu.domain.service.login;

import com.agendu.domain.port.StudentRepository;
import com.agendu.domain.utilitarian.Message;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServiceLogin
{
    private final StudentRepository studentRepository;
    private final ServiceGenerateToken serviceGenerateToken;
    private final ServiceEncryptText serviceEncryptText;

    public ServiceLogin(StudentRepository studentRepository, ServiceGenerateToken serviceGenerateToken, ServiceEncryptText serviceEncryptText)
    {
        this.studentRepository = studentRepository;
        this.serviceGenerateToken = serviceGenerateToken;
        this.serviceEncryptText = serviceEncryptText;
    }

    public String login(String email, String password)
    {
        if(this.studentRepository.login(email, this.serviceEncryptText.encryptText(password)))
        {
            throw new IllegalArgumentException(Message.WRONG_EMAIL_OR_PASSWORD);
        }

        var student = this.studentRepository.getByEmail(email);
        var roles = new ArrayList<String>();

        student.getRoles().forEach(role ->
        {
            roles.add(role.getName());
        });

        return this.serviceGenerateToken.generateToken(student.getEmail(), roles);
    }
}