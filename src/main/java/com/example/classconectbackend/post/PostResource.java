package com.example.classconectbackend.post;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/post")
public class PostResource {

    private final PostService postService;

    public PostResource(PostService postService) {
        this.postService = postService;
    }

    @PutMapping("/edit")
    public ResponseEntity<PostDto> editPost(@RequestParam(name = "post-id") String postId){

        PostDto post = postService.getPost(postId);

        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<PostDto>> getPostsAll(@RequestParam(name = "team-id") String teamId){

        var posts = postService.getPosts(teamId);

        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createNewPost(@RequestBody PostRequest postRequest){

        postService.createNewPost(postRequest);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deletePost(@RequestParam(name = "post-id") String postId){

        postService.deletePost(postId);

        return new ResponseEntity<>("Post has been deleted", HttpStatus.OK);
    }

}
