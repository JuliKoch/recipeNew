package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name ="recipe",schema = "cookbook")
@Data
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name ="ID_Recipe")
    private Integer id_recipe;

    @Column(name ="name")
    private String name;

    @Column (name="description")
    private String description;

    @Column (name ="time")
    private String time;

    @Column (name ="calorie")
    private Integer calorie;

    @Column(name ="protein")
    private Integer protein;

    @Column(name ="fat")
    private Integer fat;

    @Column(name ="carbohydrate")
    private Integer carbohydrate;

    @Column(name ="Value")
    private Integer value;

    @Column(name ="url_photo")
    private String url_photo;

    @ManyToOne
    @JoinColumn(name ="ID_User")
    private User user;

    @ManyToOne
    @JoinColumn(name ="ID_TypeOfDish")
    private TypeOfDish type;



}
