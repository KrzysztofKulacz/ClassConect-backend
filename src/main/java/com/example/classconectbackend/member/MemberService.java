package com.example.classconectbackend.member;

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
}
