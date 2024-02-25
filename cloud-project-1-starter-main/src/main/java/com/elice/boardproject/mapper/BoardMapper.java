package com.elice.boardproject.mapper;

import com.elice.boardproject.entity.Board;
import com.elice.boardproject.entity.BoardDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BoardMapper {

    Board boardPostDtoToBoard(BoardDto boardDto);
}
