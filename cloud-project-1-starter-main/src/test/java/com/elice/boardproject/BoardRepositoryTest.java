package com.elice.boardproject;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import com.elice.boardproject.entity.Board;
import com.elice.boardproject.repository.BoardRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

@ExtendWith(MockitoExtension.class)
public class BoardRepositoryTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private BoardRepository boardRepository;

    @Test
    public void findById_ShouldReturnOptionalEmpty_WhenNoBoardFound() {
        // Arrange
        Long id = 1L;
        when(jdbcTemplate.queryForObject(anyString(), any(RowMapper.class), eq(id)))
                .thenThrow(EmptyResultDataAccessException.class);

        // Act
        Optional<Board> result = boardRepository.findById(id);

        // Assert
        assertTrue(result.isEmpty());
    }

    @Test
    public void findById_ShouldReturnOptionalOfBoard_WhenBoardFound() {
        // Arrange
        Long id = 1L;
        Board expectedBoard = new Board();
        when(jdbcTemplate.queryForObject(anyString(), any(RowMapper.class), eq(id)))
                .thenReturn(expectedBoard);

        // Act
        Optional<Board> result = boardRepository.findById(id);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(expectedBoard, result.get());
    }
}