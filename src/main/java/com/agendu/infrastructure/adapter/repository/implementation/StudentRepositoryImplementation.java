package com.agendu.infrastructure.adapter.repository.implementation;

import com.agendu.domain.dto.StudentSummaryDTO;
import com.agendu.domain.model.Student;
import com.agendu.domain.port.StudentRepository;
import com.agendu.domain.service.login.ServiceEncryptText;
import com.agendu.domain.validator.ValidateObject;
import com.agendu.infrastructure.adapter.entity.StudentRoleEntity;
import com.agendu.infrastructure.adapter.repository.jpa.RoleDAO;
import com.agendu.infrastructure.adapter.repository.jpa.StudentDAO;
import com.agendu.infrastructure.adapter.repository.jpa.StudentRoleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Objects;
import static com.agendu.infrastructure.service.assembler.implementation.StudentAssemblerInfrastructureImplementation.getStudentAssembler;

@Repository
public class StudentRepositoryImplementation implements StudentRepository
{
    @Autowired
    StudentDAO studentDAO;
    @Autowired
    StudentRoleDAO studentRoleDAO;
    @Autowired
    RoleDAO roleDAO;
    @Autowired
    ServiceEncryptText serviceEncryptText;

    @Override
    public List<StudentSummaryDTO> getAll()
    {
        return this.studentDAO.findAll().stream().map(getStudentAssembler()::assembleSummaryDTOFromEntity).toList();
    }

    @Override
    public StudentSummaryDTO getById(Long id)
    {
        return this.studentDAO.findById(id).map(getStudentAssembler()::assembleSummaryDTOFromEntity).orElse(null);
    }

    @Override
    public StudentSummaryDTO getByEmail(String email)
    {
        var student = this.studentDAO.findByEmail(email);

        if(ValidateObject.isNull(student))
        {
            return null;
        }

        return getStudentAssembler().assembleSummaryDTOFromEntity(student);
    }

    @Override
    public Long save(Student student)
    {
        var entity = getStudentAssembler().assembleEntityFromDomain(student);
        var roleId = saveStudentRole(entity.getRoles().get(0));
        var roles = this.studentRoleDAO.findAll().stream().toList();
        var filterRoles = roles.stream().filter(filter -> Objects.equals(filter.getId(), roleId)).toList();

        entity.setRoles(filterRoles);
        entity.setPassword(this.serviceEncryptText.encryptText(entity.getPassword()));

        return this.studentDAO.save(entity).getId();
    }

    private Long saveStudentRole(StudentRoleEntity studentRole)
    {
        var role = this.roleDAO.findById(studentRole.getId()).orElse(null);
        var studentRoles = this.studentRoleDAO.findAll();
        var lastIndex = 1L;

        if(!studentRoles.isEmpty())
        {
            lastIndex = studentRoles.get(studentRoles.size() - 1).getId() + 1;
        }

        studentRole.setId(lastIndex);
        studentRole.setRole(role);

        return this.studentRoleDAO.save(studentRole).getId();
    }

    @Override
    public Long modify(Long id, Student student)
    {
        var entity = getStudentAssembler().assembleEntityFromDomain(student);

        entity.setId(id);

        return this.studentDAO.save(getStudentAssembler().assembleEntityFromDomain(student)).getId();
    }

    @Override
    public void delete(Long id)
    {
        this.studentDAO.deleteById(id);
    }

    @Override
    public boolean exists(Long id)
    {
        return this.studentDAO.existsById(id);
    }

    @Override
    public boolean login(String email, String password)
    {
        return ValidateObject.isNull(this.studentDAO.findByEmailAndPassword(email, password));
    }
}