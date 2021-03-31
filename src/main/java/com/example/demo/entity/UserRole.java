package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name ="user_role", schema = "cookbook")
@Data
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name ="id_user_role")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_role")
    private Role role;


}
