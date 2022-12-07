package com.example.classconectbackend.member;

import com.example.classconectbackend.team.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final TeamRepository teamRepository;

    public MemberService(MemberRepository memberRepository, TeamRepository teamRepository) {
        this.memberRepository = memberRepository;
        this.teamRepository = teamRepository;
    }

    public void deleteMember(String id) {

        memberRepository.delete(memberRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new IllegalStateException("Member doesn't exist")));
    }
}
