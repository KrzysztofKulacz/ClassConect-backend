package com.example.classconectbackend.member;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/member")
public class MemberResource {

    private final MemberService memberService;

    public MemberResource(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/isUserWithinGroup")
    public ResponseEntity<Boolean> isUserWithinGroup(@RequestParam("groupId")UUID groupId,
                                                     @RequestParam("userId")UUID userId){

        var isUserPresent = memberService.isUserWithinGroup(groupId,userId);

        return new ResponseEntity<>(isUserPresent,HttpStatus.OK);
    }

}
