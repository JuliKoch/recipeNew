package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
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

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(schema = "cookbook",name="user_role",
//            joinColumns = {@JoinColumn(name ="ID_User",referencedColumnName = "ID_User")},
//            inverseJoinColumns = {@JoinColumn(name ="ID_Role",referencedColumnName = "ID_Role")}
//    )
//    List<Role> roleList=new ArrayList<>(0);




}
