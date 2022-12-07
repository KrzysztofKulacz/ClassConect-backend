package com.example.classconectbackend.utils.mappers;

import com.example.classconectbackend.team.Team;
import com.example.classconectbackend.team.TeamDto;

public class TeamMapper {

    public static TeamDto mapToDto(Team team){

        return new TeamDto(team.getTeamAdmin(), team.getSubject(), team.getPassword(),
                team.getCreationDate(), team.getPosts(), team.getMembers());
    }
}
