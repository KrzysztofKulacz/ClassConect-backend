package com.example.classconectbackend.member;

import com.example.classconectbackend.team.Team;
import com.example.classconectbackend.team.TeamRepository;
import com.example.classconectbackend.team.TeamRequest;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final TeamRepository teamRepository;

    public MemberService(MemberRepository memberRepository, TeamRepository teamRepository) {
        this.memberRepository = memberRepository;
        this.teamRepository = teamRepository;
    }

    public void createNewTeam(TeamRequest teamRequest){

        var newTeam = new Team();
        var creationDate = LocalDateTime.now();

        var member = memberRepository.findByEmail(teamRequest.getMember_email())
                .orElseThrow(() -> new IllegalStateException("member doesn't exist"));

        newTeam.setTeamAdmin(member.getMemberId());
        newTeam.setSubject(teamRequest.getSubject());
        newTeam.setPassword(teamRequest.getPassword());
        newTeam.setCreationDate(creationDate);

        member.addTeam(newTeam);

        var saveTeam = memberRepository.save(member);

    }

    public Team getOneTeam(String teamId) {

        var uuidTeamId = UUID.fromString(teamId);
        var team = teamRepository.findById(uuidTeamId)
                .orElseThrow(() -> new IllegalStateException("team doesn't exist"));;

        return team;

    }
}
