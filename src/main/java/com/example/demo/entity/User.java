package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="users",schema ="cookbook")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name ="ID_User")
    private Integer id;

    @Column(name ="Login")
    private String login;

    @Column(name ="Password")
    private String password;

}
