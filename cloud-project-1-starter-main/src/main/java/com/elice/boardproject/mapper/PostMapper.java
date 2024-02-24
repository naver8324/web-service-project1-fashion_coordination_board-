package com.elice.boardproject.mapper;

import com.elice.boardproject.entity.Post;
import com.elice.boardproject.entity.PostDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper {

    Post postPostDTOToPost(PostDto postDto);
}
