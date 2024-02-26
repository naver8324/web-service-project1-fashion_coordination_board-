package com.elice.boardproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.beans.ConstructorProperties;

@Getter
@Setter
public class PostDto {
    private String title;
    private String content;

    @ConstructorProperties({"title", "content"})
    public PostDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
