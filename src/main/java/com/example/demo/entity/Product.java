package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name ="Product",schema = "cookbook")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column (name ="ID_List")
    private Integer id;

    @Column (name ="quantity")
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name ="ID_recipe")
    private Recipe recipe;

    @ManyToOne
    @JoinColumn(name ="ID_ingredient")
    private Ingredient ingredient;

    @ManyToOne
    @JoinColumn(name ="ID_Unit")
    private Unit unit;

}
