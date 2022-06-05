package com.agendu.infrastructure.controller;

import com.agendu.application.dto.LoginDTO;
import com.agendu.application.service.login.ServiceApplicationLogin;
import com.agendu.domain.utilitarian.Message;
import com.agendu.infrastructure.aspect.LogExecutionTime;
import com.agendu.infrastructure.controller.response.Response;
import com.agendu.infrastructure.controller.response.enumerator.StatusResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/login")
@Tag(name = "Login Controller")
public class LoginController
{
    @Autowired
    ServiceApplicationLogin serviceLogin;

    @PostMapping
    @LogExecutionTime
    @Operation(summary = "Login", description = "This is used to log in the app")
    public Response<String> login(@RequestBody LoginDTO login)
    {
        Response<String> response = new Response<>();

        response.setStatus(StatusResponse.SUCCESSFUL);
        response.addMessage(Message.LOGIN_SUCCESSFUL);

        response.setData(List.of(this.serviceLogin.login(login)));

        return response;
    }
}