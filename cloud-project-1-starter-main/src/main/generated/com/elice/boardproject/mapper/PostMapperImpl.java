package com.elice.boardproject.mapper;

import com.elice.boardproject.entity.Post;
import com.elice.boardproject.entity.PostDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-24T12:59:41+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class PostMapperImpl implements PostMapper {

    @Override
    public Post postPostDTOToPost(PostDto postDto) {
        if ( postDto == null ) {
            return null;
        }

        Post post = new Post();

        post.setTitle( postDto.getTitle() );
        post.setContent( postDto.getContent() );

        return post;
    }
}
