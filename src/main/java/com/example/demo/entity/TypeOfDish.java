package com.example.demo.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name ="typeofdish",schema = "cookbook")
@Data
public class TypeOfDish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column (name ="id_type_of_dish")
    private Integer id;

    @Column (name ="type_of_dish")
    private String typeOfDish;

}
