package com.agendu.infrastructure.controller;

import com.agendu.application.dto.StudentDTO;
import com.agendu.application.service.student.ServiceApplicationSaveStudent;
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
@RequestMapping("/api/students")
@Tag(name = "Student Controller")
public class StudentController
{
    @Autowired
    ServiceApplicationSaveStudent serviceSaveStudent;

    @PostMapping
    @LogExecutionTime
    @Operation(summary = "Save Student", description = "This is used to save a student in the app")
    public Response<Long> save(@RequestBody StudentDTO student)
    {
        Response<Long> response = new Response<>();

        response.setData(List.of(serviceSaveStudent.save(student)));

        response.addMessage(Message.STUDENT_CREATION_SUCCESSFUL);

        response.setStatus(StatusResponse.SUCCESSFUL);

        return response;
    }
}