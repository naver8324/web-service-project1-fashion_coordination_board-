package com.elice.boardproject;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.elice.boardproject.controller.BoardController;
import com.elice.boardproject.entity.Board;
import com.elice.boardproject.entity.Post;
import com.elice.boardproject.mapper.BoardMapper;
import com.elice.boardproject.service.BoardService;
import com.elice.boardproject.service.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.Model;

import java.util.Arrays;

public class BoardControllerTest {

    @Test
    public void getBoard_ShouldReturnCorrectPage_WhenValidBoardId() {
        // Arrange
        Long boardId = 1L;
        int page = 0;
        int size = 10;
        String keyword = "example";
        Board board = new Board(); // 가짜 Board 객체 생성
        Page<Post> postPage = new PageImpl<>(Arrays.asList(new Post(), new Post())); // 가짜 Post 페이지 생성
        Model model = mock(Model.class); // 가짜 Model 객체 생성

        // BoardService와 PostService의 동작을 가정하여 가짜 객체를 생성
        BoardService boardService = mock(BoardService.class);
        when(boardService.findBoardById(boardId)).thenReturn(board);
        PostService postService = mock(PostService.class);
        when(postService.findPostsByBoardAndKeyword(eq(board), eq(keyword), any(PageRequest.class))).thenReturn(postPage);
        BoardMapper boardMapper = mock(BoardMapper.class);
        // Controller 생성
        BoardController boardController = new BoardController(boardService, postService, boardMapper);

        // Act
        String viewName = boardController.getBoard(boardId, page, size, keyword, model);

        // Assert
        assertEquals("board/board", viewName); // 정상적인 뷰 이름 확인
        verify(model).addAttribute("board", board); // Model에 board 속성이 추가되었는지 확인
        verify(model).addAttribute("keyword", keyword); // Model에 keyword 속성이 추가되었는지 확인
        verify(model).addAttribute("postPage", postPage); // Model에 postPage 속성이 추가되었는지 확인
    }
}