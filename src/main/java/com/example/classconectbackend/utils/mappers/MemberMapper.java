package com.example.classconectbackend.utils.mappers;


import com.example.classconectbackend.member.Member;
import com.example.classconectbackend.member.MemberDto;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {

    public static MemberDto mapToDto(Member member){

        return new MemberDto(member.getNickName(), member.getEmail(), member.getRole());
    }
}
