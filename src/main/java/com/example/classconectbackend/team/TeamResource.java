package com.example.classconectbackend.team;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/team")
public class TeamResource {

    private final TeamService teamService;

    public TeamResource(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping("/create")
    public ResponseEntity<TeamDto> create(@RequestBody TeamCreationRequest teamCreationRequest){

        var teamDto = teamService.createNewTeam(teamCreationRequest);

        return new ResponseEntity<>(teamDto,HttpStatus.CREATED);
    }

    @PostMapping("/join")
    public ResponseEntity<TeamDto> joinToTeam(@Valid @RequestBody TeamJoinRequest teamJoinRequest){

        var teamDto = teamService.joinToTeam(teamJoinRequest);

        return new ResponseEntity<>(teamDto,HttpStatus.CREATED);
    }

    @GetMapping("/get-one")
    public ResponseEntity<TeamDto> getTeam(@RequestParam(name = "team-id") String teamId){

        var teamDTO = teamService.getTeam(teamId);

        return new ResponseEntity<>(teamDTO, HttpStatus.OK);
    }

    @GetMapping("/get-member-all")
    public ResponseEntity<List<TeamDto>> getMemberTeams(@RequestParam(name = "email") String email){

        var teamDTO = teamService.getMemberTeams(email);

        return new ResponseEntity<>(teamDTO, HttpStatus.OK);
    }

    @GetMapping("/get-available-all")
    public ResponseEntity<List<TeamDto>> getAvailableAll(){

        var teamDTO = teamService.getAvailableTeams();

        return new ResponseEntity<>(teamDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteTeam(@RequestParam(name = "groupId") String teamId){

        teamService.deleteTeam(teamId);

        return new ResponseEntity<>( HttpStatus.OK);
    }
}
