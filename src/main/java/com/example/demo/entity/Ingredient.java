package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name ="ingredient",schema = "cookbook")
@Data
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column (name ="ID_Ingredient")
    private Integer id;

    @Column (name ="ingredient")
    private String ingredient;
}
