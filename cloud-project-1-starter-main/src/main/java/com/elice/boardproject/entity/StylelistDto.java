package com.elice.boardproject.entity;

import lombok.Getter;
import lombok.Setter;

import java.beans.ConstructorProperties;

@Getter
@Setter
public class StylelistDto {
    private String loginId;
    private String password;
    private String nickname;

    @ConstructorProperties({"loginId", "password", "nickname"})
    public StylelistDto(String loginId, String password, String nickname) {
        this.loginId = loginId;
        this.password = password;
        this.nickname = nickname;
    }
}
