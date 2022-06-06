package com.agendu.infrastructure.controller;

import com.agendu.application.dto.StudentDTO;
import com.agendu.application.service.student.*;
import com.agendu.domain.dto.StudentSummaryDTO;
import com.agendu.domain.utilitarian.Message;
import com.agendu.infrastructure.aspect.LogExecutionTime;
import com.agendu.infrastructure.aspect.Secured;
import com.agendu.infrastructure.controller.response.Response;
import com.agendu.infrastructure.controller.response.enumerator.StatusResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/students")
@Tag(name = "Student Controller")
public class StudentController
{
    @Autowired
    ServiceApplicationSaveStudent serviceSaveStudent;
    @Autowired
    ServiceApplicationGetStudents serviceGetStudents;
    @Autowired
    ServiceApplicationGetStudentByEmail serviceGetStudentByEmail;
    @Autowired
    ServiceApplicationGetStudentById serviceGetStudentById;
    @Autowired
    ServiceApplicationUpdateStudent serviceUpdateStudent;
    @Autowired
    ServiceApplicationDeleteUser serviceDeleteUser;

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

    @PutMapping("/{id}")
    @Secured(roles = {"ROLE_REGISTERED"})
    @LogExecutionTime
    @Operation(summary = "Update Student", description = "This is used to update a student in the app using an ID")
    public Response<Long> update(@RequestBody StudentDTO student, @PathVariable Long id)
    {
        Response<Long> response = new Response<>();

        response.setData(List.of(serviceUpdateStudent.update(id, student)));

        response.addMessage(Message.STUDENT_UPDATE_SUCCESSFUL);

        response.setStatus(StatusResponse.SUCCESSFUL);

        return response;
    }

    @DeleteMapping("/{id}")
    @Secured(roles = {"ROLE_REGISTERED"})
    @LogExecutionTime
    @Operation(summary = "Delete Student", description = "This is used to delete a student in the app using an ID")
    public Response<Long> delete(@PathVariable Long id)
    {
        Response<Long> response = new Response<>();

        this.serviceDeleteUser.delete(id);

        response.addMessage(Message.STUDENT_DELETE_SUCCESSFUL);

        response.setStatus(StatusResponse.SUCCESSFUL);

        return response;
    }

    @GetMapping
    @Secured(roles = {"ROLE_REGISTERED"})
    @LogExecutionTime
    @Operation(summary = "Get Students", description = "This is used to get all the students registered in the app")
    public Response<StudentSummaryDTO> get()
    {
        Response<StudentSummaryDTO> response = new Response<>();

        response.setData(this.serviceGetStudents.getAll());

        response.addMessage(Message.STUDENTS_CONSULTED_SUCCESSFUL);

        response.setStatus(StatusResponse.SUCCESSFUL);

        return response;
    }

    @GetMapping("/student/{email}")
    @Secured(roles = {"ROLE_REGISTERED"})
    @LogExecutionTime
    @Operation(summary = "Get By Email", description = "This is used to get by email a student registered in the app")
    public Response<StudentSummaryDTO> getByEmail(@PathVariable String email)
    {
        Response<StudentSummaryDTO> response = new Response<>();

        response.setData(List.of(this.serviceGetStudentByEmail.getByEmail(email)));

        response.addMessage(Message.STUDENT_CONSULTED_BY_EMAIL_SUCCESSFUL + email);

        response.setStatus(StatusResponse.SUCCESSFUL);

        return response;
    }

    @GetMapping("/{id}")
    @Secured(roles = {"ROLE_REGISTERED"})
    @LogExecutionTime
    @Operation(summary = "Get By ID", description = "This is used to get by email a student registered in the app")
    public Response<StudentSummaryDTO> getById(@PathVariable Long id)
    {
        Response<StudentSummaryDTO> response = new Response<>();

        response.setData(List.of(this.serviceGetStudentById.getById(id)));

        response.addMessage(Message.STUDENT_CONSULTED_BY_ID_SUCCESSFUL + id);

        response.setStatus(StatusResponse.SUCCESSFUL);

        return response;
    }
}