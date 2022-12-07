package com.example.classconectbackend.team;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/team")
public class TeamResource {

    private final TeamService teamService;

    public TeamResource(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createNewTeam(@RequestBody TeamRequest teamRequest){

        teamService.createNewTeam(teamRequest);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/get-one")
    public ResponseEntity<TeamDto> getTeamById(@RequestParam(name = "team-id") String teamId){

        var teamDTO = teamService.getTeam(teamId);

        //var headers = new HttpHeaders();
        //headers.add("JWT-TOKEN", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJrcnp5c3p0b2YubWNrdWxhY3pAZ21haWwuY29tIiwiUk9MRVMiOlsiVklFV19HUk9VUFMiLCJERUxFVEVfR1JPVVBTIiwiRURJVF9HUk9VUFMiXSwiaXNzIjoiQ2xhc3NDb25uZWN0In0.G813PhHjZWjLKwFTaq597dZilk0KqV8DbyiPaxPOrKs");
        //return new ResponseEntity<>(teamDTO, headers, HttpStatus.OK);
        return new ResponseEntity<>(teamDTO, HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public ResponseEntity<Void> getAllTeams(){

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteTeam(@RequestParam(name = "team-id") String teamId){

        teamService.deleteTeam(teamId);

        return new ResponseEntity<>("Team has been deleted", HttpStatus.OK);
    }
}
