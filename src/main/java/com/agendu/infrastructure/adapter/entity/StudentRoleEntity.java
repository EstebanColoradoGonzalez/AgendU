package com.agendu.infrastructure.adapter.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "studentrole")
public class StudentRoleEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="studentrole_id_seq")
    @SequenceGenerator(name="studentrole_id_seq", sequenceName="studentrole_id_seq", allocationSize=1)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "role")
    private RoleEntity role;
}