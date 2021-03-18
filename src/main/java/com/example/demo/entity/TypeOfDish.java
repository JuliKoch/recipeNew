package com.example.demo.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name ="TypeOfDish",schema = "cookbook")
@Data
public class TypeOfDish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column (name ="ID_TypeOfDish")
    private Integer id;

    @Column (name ="TypeOfDish")
    private String TypeOfDish;

}
