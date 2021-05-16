package com.example.demo.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="users",schema ="cookbook")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name ="id_user")
    private Integer id;

    @Column(name ="Login")
    private String login;

    @Column(name ="Password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(schema = "cookbook",name="user_role",
            joinColumns = {@JoinColumn(name ="id_user",referencedColumnName = "id_user")},
            inverseJoinColumns = {@JoinColumn(name ="id_role",referencedColumnName = "id_role")}
    )
    private List<Role> roles;

    @LastModifiedDate
    @Column(name = "updated")
    private Date updated;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;



}
