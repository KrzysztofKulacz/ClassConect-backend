package com.example.classconectbackend.utils.mappers;

import com.example.classconectbackend.post.Post;
import com.example.classconectbackend.post.PostDto;

public class PostMapper {
    public static PostDto mapToDto(Post post) {

        return new PostDto(post.getTitle(), post.getText(), post.getCreationDate(), post.getMember(), post.getTeam());
    }
}
