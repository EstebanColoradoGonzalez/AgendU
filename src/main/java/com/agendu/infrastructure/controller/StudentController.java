package com.agendu.infrastructure.controller;

import com.agendu.application.dto.StudentDTO;
import com.agendu.application.service.student.ServiceApplicationSaveStudent;
import com.agendu.domain.utilitarian.Message;
import com.agendu.infrastructure.controller.response.Response;
import com.agendu.infrastructure.controller.response.enumerator.StatusResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController
{
    @Autowired
    private ServiceApplicationSaveStudent serviceSaveStudent;

    @PostMapping
    public Response<Long> save(@RequestBody StudentDTO student)
    {
        Response<Long> response = new Response<>();

        response.setData(List.of(serviceSaveStudent.save(student)));

        response.addMessage(Message.STUDENT_CREATION_SUCCESSFUL);

        response.setStatus(StatusResponse.SUCCESSFUL);

        return response;
    }
}