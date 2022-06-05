package com.agendu.infrastructure.adapter.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
public class StudentEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="student_id_seq")
    @SequenceGenerator(name="student_id_seq", sequenceName="student_id_seq", allocationSize=1)
    private Long id;
    private String name;
    private String email;
    private String password;
    @OneToMany
    @JoinColumn(name = "student")
    private List<StudentRoleEntity> roles;
}