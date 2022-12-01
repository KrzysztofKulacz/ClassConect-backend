package com.example.classconectbackend.member;

import com.example.classconectbackend.team.Team;
import com.example.classconectbackend.team.TeamRequest;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class MemberService {

    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void createNewTeam(TeamRequest teamRequest, String email){

        var newTeam = new Team();
        var creationDate = LocalDateTime.now();

        Member member = memberRepository.findByEmail(email).orElseThrow(() -> new IllegalStateException());

        newTeam.setTeamAdmin(member.getMemberId());
        newTeam.setSubject(teamRequest.getSubject());
        newTeam.setPassword(teamRequest.getPassword());
        newTeam.setCreationDate(creationDate);

        member.addTeam(newTeam);

        var saveTeam = memberRepository.save(member);

    }
}
