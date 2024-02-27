package com.elice.boardproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.beans.ConstructorProperties;

@Getter
@Builder
public class BoardDto {
    private String name;
    private String description;

    @ConstructorProperties({"name", "description"})
    public BoardDto(String name, String description) {
        this.name = name;
        this.description = description;
    }
}