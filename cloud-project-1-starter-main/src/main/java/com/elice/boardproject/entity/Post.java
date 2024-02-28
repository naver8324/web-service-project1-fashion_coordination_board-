package com.elice.boardproject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Post extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "board_id", nullable = false)
    private Board board;

    @Column(nullable = false, length = 60)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    public Post(Board board, String title, String content) {
        this.board = board;
        this.title = title;
        this.content = content;
    }

    public void setBoard(Board board) {
        this.board = board;
        if (!this.board.getPosts().contains(this)) {
            this.board.getPosts().add(this);
        }
    }
}

//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Entity
//public class Post {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;
//
//    @ManyToOne
//    @JoinColumn(name = "stylelist_id")
//    private Stylelist stylelist;
//
//    @Column(name = "user_comment")
//    private String userComment;
//
//    @Column(name = "codiphoto_path")
//    private String codiphotoPath;
//
//    @Column(name = "stylelist_comment")
//    private String stylelistComment;
//
//    private Timestamp uploadTime;
//
//
//    @Builder // setter 대신 빌더 패턴 적용
//    public Post(User user, Stylelist stylelist, String userComment, String codiphotoPath, String stylelistComment, Timestamp uploadTime) {
//        this.user = user;
//        this.stylelist = stylelist;
//        this.userComment = userComment;
//        this.codiphotoPath = codiphotoPath;
//        this.stylelistComment = stylelistComment;
//        this.uploadTime = uploadTime;
//    }
//}
