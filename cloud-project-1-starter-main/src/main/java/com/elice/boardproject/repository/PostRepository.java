package com.elice.boardproject.repository;

import com.elice.boardproject.entity.Board;
import com.elice.boardproject.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Page<Post> findAllByBoardOrderByCreatedAtDesc(Board board, Pageable pageable);
    Page<Post> findAllByBoardAndTitleContaining(Board board, String keyword, Pageable pageable);

}
