package com.example.classconectbackend;

import com.example.classconectbackend.member.Member;
import com.example.classconectbackend.member.MemberRepository;
import com.example.classconectbackend.post.Post;
import com.example.classconectbackend.team.Subject;
import com.example.classconectbackend.team.Team;
import com.example.classconectbackend.team.TeamRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.text.Position;
import java.util.UUID;

@SpringBootApplication
public class ClassConnectBackendApplication {

    public static void main(String[] args) {
        var applicationContext = SpringApplication.run(ClassConnectBackendApplication.class, args);
        var memberRepository = applicationContext.getBean(MemberRepository.class);

        var post = new Post();
        post.setTitle("Example title");
        post.setText("Example text");

        var member = new Member();
        member.setUsername("ABC");
        member.addPost(post);
        member.setEmail("Example mail");
        member.setPassword("Example password");


        var team = new Team();
        team.setSubject(Subject.MATH);
        team.setPassword("Example password");
        team.setGroupAdmin(UUID.randomUUID());
        team.addPost(post);

        member.addTeam(team);

        memberRepository.save(member);
    }

}
