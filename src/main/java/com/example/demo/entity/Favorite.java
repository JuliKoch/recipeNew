package com.example.demo.entity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name ="favorite",schema = "cookbook")
@Data
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name ="ID_Favorite")
    private Integer id;

    @ManyToOne
    @JoinColumn(name ="ID_User")
    private User user;

    @ManyToOne
    @JoinColumn(name ="ID_Recipe")
    private Recipe recipe;

}
