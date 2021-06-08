package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name ="unit",schema = "cookbook")
@Data
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column (name ="ID_Unit")
    private Integer id;

    @Column(name ="unit")
    private String unit;
}