package com.elice.boardproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "stylelist")
public class Stylelist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "login_id")
    private String loginId;
    private String password;
    private String nickname;
    @Column(name = "pr_link")
    private String prLink;
}
