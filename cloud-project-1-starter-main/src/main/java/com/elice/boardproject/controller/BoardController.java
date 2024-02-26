package com.elice.boardproject.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.elice.boardproject.entity.Board;
import com.elice.boardproject.entity.BoardDto;
import com.elice.boardproject.mapper.BoardMapper;
import com.elice.boardproject.service.BoardService;
import com.elice.boardproject.entity.Post;
import com.elice.boardproject.service.PostService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/boards")
public class BoardController {

    private final BoardService boardService;
    private final PostService postService;
    private final BoardMapper boardMapper;

    public BoardController(BoardService boardService, PostService postService, BoardMapper boardMapper) {
        this.boardService = boardService;
        this.postService = postService;
        this.boardMapper = boardMapper;
    }

    @GetMapping
    public String getBoards(Model model) {
        List<Board> boards = boardService.findBoards();
        model.addAttribute("boards", boards);
        return "board/boards";
    }

    /*
     comment 키워드 검색 기능 추가
     */
    @GetMapping("/{boardId}")
    public String getBoard(@PathVariable(name = "boardId") Long boardId,
                           @RequestParam(name = "page", defaultValue = "0") int page,
                           @RequestParam(name = "size", defaultValue = "10") int size,
                           @RequestParam(name = "keyword", required = false) String keyword,
                           Model model) {
        Board board = boardService.findBoardById(boardId);
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Post> postPage = postService.findPostsByBoardAndKeyword(board, keyword, pageRequest);

        model.addAttribute("board", board);
        model.addAttribute("keyword", keyword);
        model.addAttribute("postPage", postPage);
        return "board/board";
    }

    @GetMapping("/create")
    public String createBoard(Model model) {
        return "board/createBoard";
    }

    @PostMapping("/create")
    public String createBoardPost(@ModelAttribute BoardDto boardDto) {
        Board board = boardMapper.boardPostDtoToBoard(boardDto);
        boardService.createBoard(board);

        return "redirect:/boards";
    }

    @GetMapping("/{boardId}/edit")
    public String editBoard(@PathVariable(name = "boardId") Long boardId, Model model) {
        Board board = boardService.findBoardById(boardId);
        model.addAttribute("board", board);

        return "board/editBoard";
    }

    @PostMapping("/{boardId}/edit")
    public String editBoardPost(@PathVariable(name = "boardId") Long boardId, @ModelAttribute BoardDto boardDto) {
        Board board = boardMapper.boardPostDtoToBoard(boardDto).toBuilder().id(boardId).build();
        boardService.updateBoard(board);

        return "redirect:/boards";
    }

    @DeleteMapping("/{boardId}/delete")
    public String deleteBoard(@PathVariable(name = "boardId") Long boardId) {
        boardService.deleteBoard(boardId);

        return "redirect:/boards";
    }

}

