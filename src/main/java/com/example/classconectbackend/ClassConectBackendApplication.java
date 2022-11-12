package com.example.classconectbackend;

import com.example.classconectbackend.member.Member;
import com.example.classconectbackend.member.MemberRepository;
import com.example.classconectbackend.post.Post;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
class ClassConnectBackendApplication {

    public static void main(String[] args) {
        var applicationContext = SpringApplication.run(ClassConnectBackendApplication.class, args);
        var memberRepository = applicationContext.getBean(MemberRepository.class);

        var member = new Member();
        var post = new Post();

        post.setText("Test test");
        post.setTitle("Test title");

        member.setUsername("Test Username");
        member.setEmail("test mejl");
        member.addPost(post);
        member.setAuthorities("test auth");


        memberRepository.save(member);
    }

}