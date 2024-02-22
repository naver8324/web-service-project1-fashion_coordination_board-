package com.elice.boardproject.service;

import com.elice.boardproject.entity.Post;
import com.elice.boardproject.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService{
    @Autowired
    private PostRepository postRepository;

    @Override
    public Post getPostById(int id) {
        return postRepository.findById(id).orElse(null);
    }

    @Override
    public void savePost(Post post) {
        postRepository.save(post);
    }

}
