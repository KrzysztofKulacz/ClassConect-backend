package com.example.classconectbackend.post;

import com.example.classconectbackend.member.MemberRepository;
import com.example.classconectbackend.team.TeamRepository;
import com.example.classconectbackend.utils.mappers.PostMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

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

    public void getPost(String postId) {

        var post = postRepository.findById(UUID.fromString(postId))
                .orElseThrow(() -> new IllegalStateException("Team doesn't exist"));

        var postDTO = PostMapper.mapToDto(post);
    }

    public void createNewPost(PostRequest postRequest) {

        var newPost = new Post();
        var creationDate = LocalDateTime.now();

        var member = memberRepository.findById(postRequest.getMember())
                .orElseThrow(() -> new IllegalStateException("member doesn't exist"));
        var team = teamRepository.findById(postRequest.getTeam())
                .orElseThrow(() -> new IllegalStateException("team doesn't exist"));

        newPost.setTitle(postRequest.getTitle());
        newPost.setText(postRequest.getText());
        newPost.setCreationDate(creationDate);
        newPost.setMember(member);
        newPost.setTeam(team);

        var savePost = postRepository.save(newPost);

    }

    public void deletePost(String postId) {

        postRepository.delete(postRepository.findById(UUID.fromString(postId))
                .orElseThrow(() -> new IllegalStateException("Post has been deleted")));
    }
}
