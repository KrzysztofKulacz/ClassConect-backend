package com.example.classconectbackend.utils.mappers;


import com.example.classconectbackend.member.Member;
import com.example.classconectbackend.member.MemberDto;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

public class MemberMapper {

    public static MemberDto mapToDto(Member member){

        var  authorities = member.getAuthorities().stream()
                .map(SimpleGrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return new MemberDto(member.getNickName(), member.getEmail(), member.getRole(),
                authorities, member.getCreationDate());
    }
}
