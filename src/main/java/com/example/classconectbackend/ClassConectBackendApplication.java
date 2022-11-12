package com.example.classconectbackend;

import com.example.classconectbackend.member.Member;
import com.example.classconectbackend.member.MemberRepository;
import com.example.classconectbackend.post.Post;
import com.example.classconectbackend.team.Subject;
import com.example.classconectbackend.team.Team;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
class ClassConnectBackendApplication {

    public static void main(String[] args) {
        var applicationContext = SpringApplication.run(ClassConnectBackendApplication.class, args);
        var memberRepository = applicationContext.getBean(MemberRepository.class);

        var post = new Post();
        post.setTitle("Example title");
        post.setText("lóbie hożuf");

        var member = new Member();
        member.setUsername("Krzysió");
        member.addPost(post);
        member.setEmail("Example email");
        member.setPassword("Example member password");


        var team = new Team();
        team.setSubject(Subject.MACHINE_LEARNING);
        team.setPassword("Example team password");
        team.setTeamAdmin(UUID.randomUUID());
        team.addPost(post);

        member.addTeam(team);
        memberRepository.save(member);
    }

}