package com.example.classconectbackend.post;

import com.example.classconectbackend.member.MemberRepository;
import com.example.classconectbackend.team.TeamRepository;
import com.example.classconectbackend.utils.mappers.PostMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final MemberRepository memberRepository;
    private final TeamRepository teamRepository;

    public PostService(PostRepository postRepository, MemberRepository memberRepository, TeamRepository teamRepository) {
        this.postRepository = postRepository;
        this.memberRepository = memberRepository;
        this.teamRepository = teamRepository;
    }

    public PostDto editPost(PostDto postDto) {

        var post = postRepository.findById(postDto.getPostId())
                .orElseThrow(() -> new IllegalStateException("Post doesn't exist"));

        post.setText(postDto.getContent());
        post.setTitle(postDto.getTitle());
        post.setCreationDate(LocalDateTime.now());

        var editedPost = postRepository.save(post);

        return PostMapper.mapToDto(editedPost);
    }

    public List<PostDto> getPosts(String teamId){

        var posts = postRepository.findAllByTeamId(UUID.fromString(teamId))
                .orElseThrow(() -> new IllegalStateException("No posts found"));

        return posts
                .stream()
                .map(PostMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public PostDto createNewPost(PostRequest postRequest) {

        var newPost = new Post();
        var creationDate = LocalDateTime.now();

        var member = memberRepository.findById(postRequest.getMember())
                .orElseThrow(() -> new IllegalStateException("Member doesn't exist"));
        var team = teamRepository.findById(postRequest.getTeam())
                .orElseThrow(() -> new IllegalStateException("Team doesn't exist"));

        newPost.setTitle(postRequest.getTitle());
        newPost.setText(postRequest.getContent());
        newPost.setCreationDate(creationDate);
        newPost.setMember(member);
        newPost.setTeam(team);

        Post savedPost = postRepository.save(newPost);

        return PostMapper.mapToDto(savedPost);

    }

    public void deletePost(String postId) {
        postRepository.deletePostById(UUID.fromString(postId));
    }
}
