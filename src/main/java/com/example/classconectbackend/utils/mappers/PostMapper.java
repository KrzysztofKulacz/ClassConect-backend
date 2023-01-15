package com.example.classconectbackend.utils.mappers;

import com.example.classconectbackend.post.Post;
import com.example.classconectbackend.post.PostDto;

public class PostMapper {
    public static PostDto mapToDto(Post post) {
        return new PostDto(post.getPostId(), post.getMember().getMemberId(), post.getTeam().getTeamId(),
                post.getMember().getNickName(), post.getTitle(), post.getText(), post.getCreationDate());
    }
}
