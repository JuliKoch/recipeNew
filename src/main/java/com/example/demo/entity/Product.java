package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name ="product",schema = "cookbook")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column (name ="id_product")
    private Integer id;

    @Column (name ="quantity")
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name ="id_recipe")
    private Recipe recipe;

    @ManyToOne
    @JoinColumn(name ="id_ingredient")
    private Ingredient ingredient;

    @ManyToOne
    @JoinColumn(name ="id_unit")
    private Unit unit;

}
