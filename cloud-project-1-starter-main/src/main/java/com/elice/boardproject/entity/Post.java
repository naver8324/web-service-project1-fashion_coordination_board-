package com.elice.boardproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "stylelist_id")
    private Stylelist stylelist;

    @Column(name = "user_comment")
    private String userComment;

    @Column(name = "codiphoto_path")
    private String codiphotoPath;

    @Column(name = "stylelist_comment")
    private String stylelistComment;

    private Timestamp uploadTime;
}
