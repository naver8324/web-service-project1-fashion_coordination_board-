package com.elice.boardproject.service;

import com.elice.boardproject.entity.Post;

public interface PostService {
    Post getPostById(int id);
    void savePost(Post post);
}
