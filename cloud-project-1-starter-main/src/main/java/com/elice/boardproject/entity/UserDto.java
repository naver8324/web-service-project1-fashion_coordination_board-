package com.elice.boardproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.beans.ConstructorProperties;

@Getter
@Setter
public class UserDto {
    private String loginId;
    private String password;
    private String name;
//    private int height;
//    private int weight;
//    private FavoriteStyle favoriteStyle;
//    private String favoriteBrand;
//    private String photoPath;

    @ConstructorProperties({"loginId", "password", "name"})
    public UserDto(String loginId, String password, String name) {
        this.loginId = loginId;
        this.password = password;
        this.name = name;
    }
//    @ConstructorProperties({"loginId", "password", "name", "height", "weight", "favoriteStyle", "favoriteBrand", "photoPath"})
//    public UserDto(String loginId, String password, String name, int height, int weight, FavoriteStyle favoriteStyle, String favoriteBrand, String photoPath) {
//        this.loginId = loginId;
//        this.password = password;
//        this.name = name;
//        this.height = height;
//        this.weight = weight;
//        this.favoriteStyle = favoriteStyle;
//        this.favoriteBrand = favoriteBrand;
//        this.photoPath = photoPath;
//    }
}
