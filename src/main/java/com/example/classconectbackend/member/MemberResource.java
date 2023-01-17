package com.example.classconectbackend.member;

import com.example.classconectbackend.team.TeamDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/v1/member")
public class MemberResource {

    private final MemberService memberService;

    public MemberResource(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/is-user-within-group")
    public ResponseEntity<Boolean> isUserWithinGroup(@RequestParam("groupId") UUID groupId,
                                                     @RequestParam("userId") UUID userId) {

        var isUserPresent = memberService.isUserWithinGroup(userId, groupId);
        return new ResponseEntity<>(isUserPresent, HttpStatus.OK);
    }

    @GetMapping("/remove-from-group")
    public ResponseEntity<TeamDto> removeMemberFromGroup(@RequestParam("groupId") UUID groupId,
                                                         @RequestParam("userId") UUID userId) {

        var removedTeam = memberService.removeTeamFromUser(groupId, userId);

        return new ResponseEntity<>(removedTeam, HttpStatus.OK);
    }

}
