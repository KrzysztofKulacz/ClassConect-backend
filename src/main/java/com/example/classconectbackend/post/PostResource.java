package com.example.classconectbackend.post;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/post")
@Transactional
public class PostResource {

    private final PostService postService;

    public PostResource(PostService postService) {
        this.postService = postService;
    }

    @PutMapping("/edit")
    public ResponseEntity<PostDto> editPost(@RequestBody PostDto postDto) {

        var editedPost = postService.editPost(postDto);

        return new ResponseEntity<>(editedPost, HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<PostDto>> getPostsAll(@RequestParam(name = "team") String teamId) {

        var posts = postService.getPosts(teamId);

        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<PostDto> createNewPost(@RequestBody PostRequest postRequest) {

        var createdPost = postService.createNewPost(postRequest);

        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deletePost(@RequestParam(name = "post") String postId) {

        postService.deletePost(postId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
