package com.example.classconectbackend.member;

import com.example.classconectbackend.team.TeamDto;
import com.example.classconectbackend.utils.mappers.TeamMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public boolean isUserWithinGroup(UUID userId, UUID groupId) {
        return memberRepository.isUserWithinGroup(userId, groupId);
    }

    public TeamDto removeTeamFromUser(UUID teamId, UUID memberId) {

        var requestedMember = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalStateException("User not found"));

        var requestedTeam = requestedMember.getTeams()
                .stream()
                .filter(team -> team.getTeamId().equals(teamId))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Team not found"));

        requestedMember.removeTeam(requestedTeam);

        memberRepository.save(requestedMember);

        return TeamMapper.mapToDto(requestedTeam);
    }
}
