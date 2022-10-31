package com.example.classconectbackend.integration;

import com.example.classconectbackend.member.Member;
import com.example.classconectbackend.member.MemberRepository;
import com.example.classconectbackend.post.Post;
import com.example.classconectbackend.post.PostRepository;
import com.example.classconectbackend.squad.Squad;
import com.example.classconectbackend.squad.SquadRepository;
import com.example.classconectbackend.squad.Subject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.LIST;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
public class DbIntegrationTest {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private SquadRepository squadRepository;
    @Autowired
    private PostRepository postRepository;

    @Test
    void shouldTestDbIntegration() {
       //GIVEN
        // WHEN

        //THEN

//assertThat(new Member().getSquad).isNotNull();
        //Member m = memberRepository.finByID("adadadad");
        //assserThat(m.getSquad).isNotNull
        // cche z member a sciagnac grupy i posty


        Member member = new Member();
        member.setId(UUID.randomUUID());
        member.setUsername("kristof");
        Post post = new Post();
        post.setId(UUID.randomUUID());
        post.setMember(member);
        member.setPosts(List.of(post));
        Squad squad = new Squad();
        squad.setSquadAdmin(UUID.randomUUID());
        squad.setPosts(List.of(post));
        post.setSquad(squad);
        //member.setGroups(List.of(squad));


        //memberRepository.save(member);
        //Post post = postRepository.save(new Post(squad, member, "Algebra", "to jest tekst testowy. Zobaczymy czy zadziała"));
        member.addSquad(squad);
        Member save = memberRepository.saveAndFlush(member);
        Optional<Squad> byId = squadRepository.findById(save.getSquads().get(0).getSquadAdmin());
        int x = 10;

        //TODO
        // ściąganie z member posta i grupy, z posta grupe i membera itd
    }
}


