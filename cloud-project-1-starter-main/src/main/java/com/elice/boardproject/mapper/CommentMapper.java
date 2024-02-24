package com.elice.boardproject.mapper;

import com.elice.boardproject.entity.Comment;
import com.elice.boardproject.entity.CommentDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    Comment commentDtoToComment(CommentDto commentDto);
}
