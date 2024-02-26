package com.elice.boardproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.beans.ConstructorProperties;

@Getter
@Setter
public class CommentDto {
    private String content;

    @ConstructorProperties({"content"})
    public CommentDto(String content){
        this.content = content;
    }
}
