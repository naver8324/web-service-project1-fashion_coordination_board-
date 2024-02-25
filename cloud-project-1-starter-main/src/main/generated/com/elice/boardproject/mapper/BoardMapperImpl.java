package com.elice.boardproject.mapper;

import com.elice.boardproject.entity.Board;
import com.elice.boardproject.entity.BoardDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-24T12:59:41+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class BoardMapperImpl implements BoardMapper {

    @Override
    public Board boardPostDtoToBoard(BoardDto boardDto) {
        if ( boardDto == null ) {
            return null;
        }

        Board.BoardBuilder board = Board.builder();

        board.name( boardDto.getName() );
        board.description( boardDto.getDescription() );

        return board.build();
    }
}
