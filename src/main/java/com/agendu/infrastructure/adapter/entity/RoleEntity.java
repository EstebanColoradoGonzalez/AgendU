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
@Table(name = "role")
public class RoleEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="role_id_seq")
    @SequenceGenerator(name="role_id_seq", sequenceName="role_id_seq", allocationSize=1)
    private Long id;
    private String name;
}