package com.example.demo.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "role",schema="cookbook")
@Data
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name ="ID_Role")
    private Integer id;

    @Column(name ="name_role")
    private String nameRole;

    @ManyToMany(mappedBy = "roles",fetch=FetchType.LAZY)

    private List<User> users;

    @Override
    public String getAuthority() {
        return nameRole;
    }
}
