package com.elice.boardproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "login_id")
    private String loginId;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int height;

    @Column(nullable = false)
    private int weight;

    @Column(name = "photo_path")
    private String photoPath;

    @Column(name = "favorite_style")
    private String favoriteStyle;

    @Column(name = "favorite_Brand")
    private String favoriteBrand;

    @Column(name = "favorite_stylelist")
    private String favoriteStylelist;
}
