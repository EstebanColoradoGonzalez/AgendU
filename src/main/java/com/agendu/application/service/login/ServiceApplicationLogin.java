package com.agendu.application.service.login;

import com.agendu.application.dto.LoginDTO;
import com.agendu.domain.service.login.ServiceLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceApplicationLogin
{
    @Autowired
    ServiceLogin serviceLogin;

    public String login(LoginDTO login)
    {
        return this.serviceLogin.login(login.getEmail(), login.getPassword());
    }
}
