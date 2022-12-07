package com.example.classconectbackend.member;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberResource {

    private final MemberService memberService;

    public MemberResource(MemberService memberService) {
        this.memberService = memberService;
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteMember(@RequestParam(name = "member-id") String memberId){

        memberService.deleteMember(memberId);

        return new ResponseEntity<>("Member has been deleted", HttpStatus.OK);
    }

}
