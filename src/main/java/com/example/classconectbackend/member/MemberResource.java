package com.example.classconectbackend.member;

import com.example.classconectbackend.team.TeamRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
public class MemberResource {

    private final MemberService memberService;

    public MemberResource(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/create-team")
    public ResponseEntity<Void> createNewTeam(@RequestBody TeamRequest teamRequest){

        memberService.createNewTeam(teamRequest, "krzysztof.mckulacz@gmail.com");

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping()
    public ResponseEntity<Void> deleteTeam(){
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("get-teams")
    public ResponseEntity<Void> getAllTeams(){

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
