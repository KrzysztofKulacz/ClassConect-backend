package com.example.classconectbackend.team;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/team")
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
    public ResponseEntity<TeamDto> getTeam(@RequestParam(name = "team-id") String teamId){

        var teamDTO = teamService.getTeam(teamId);

        return new ResponseEntity<>(teamDTO, HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<TeamDto>> getTeams(@RequestParam(name = "email") String email){

        var teamDTO = teamService.getTeams(email);

        return new ResponseEntity<>(teamDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteTeam(@RequestParam(name = "team-id") String teamId){

        teamService.deleteTeam(teamId);

        return new ResponseEntity<>("Team has been deleted", HttpStatus.OK);
    }
}
