package com.example.classconectbackend;

import com.example.classconectbackend.member.Member;
import com.example.classconectbackend.post.Post;
import com.example.classconectbackend.team.Subject;
import com.example.classconectbackend.team.Team;
import com.example.classconectbackend.team.TeamRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
class ClassConnectBackendApplication {

    public static void main(String[] args) {
        var applicationContext = SpringApplication.run(ClassConnectBackendApplication.class, args);
        var teamRepository = applicationContext.getBean(TeamRepository.class);

        var post = new Post();
        post.setTitle("TeamTestTitle");

        var member = new Member();
        member.addPost(post);


        var team = new Team();
        team.setSubject(Subject.MATH);
        team.setPassword(UUID.randomUUID().toString());
        team.addPost(post);

        teamRepository.save(team);
    }

}