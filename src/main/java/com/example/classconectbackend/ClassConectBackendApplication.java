package com.example.classconectbackend;

import com.example.classconectbackend.member.Member;
import com.example.classconectbackend.member.MemberRepository;
import com.example.classconectbackend.post.Post;
import com.example.classconectbackend.post.PostRepository;
import com.example.classconectbackend.squad.Squad;
import com.example.classconectbackend.squad.SquadRepository;
import com.example.classconectbackend.squad.Subject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
public class ClassConectBackendApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ClassConectBackendApplication.class, args);
        SquadRepository squadRepository = run.getBean(SquadRepository.class);
        MemberRepository memberRepository = run.getBean(MemberRepository.class);
        PostRepository postRepository = run.getBean(PostRepository.class);

        Member member = new Member(UUID.randomUUID(), "K", "1234", "@", false, false, false,false, "yes", null, null);
        //member.setId(UUID.randomUUID());
        //member.setUsername("kristof");
        Squad squad = new Squad(UUID.randomUUID(), Subject.MATH, "12345", List.of(member), null);
        Post post = new Post(UUID.randomUUID(), "member", "Subject.MATH", member, squad);
        //post.setId(UUID.randomUUID());
        //post.setMember(member);
        //member.setPosts(List.of(post));

        //squad.setSquadAdmin(UUID.randomUUID());
        squad.setPosts(List.of(post));
        //post.setSquad(squad);

        //member.setGroups(List.of(squad));
        //memberRepository.save(member);

        //Post post = postRepository.save(new Post(squad, member, "Algebra", "to jest tekst testowy. Zobaczymy czy zadziała"));
        //member.addSquad(squad);
        member.addPost(post);
        Member save = memberRepository.saveAndFlush(member);
        Optional<Squad> byId = squadRepository.findById(save.getSquads().get(0).getSquadAdmin());
        int x = 10;
    }

}
