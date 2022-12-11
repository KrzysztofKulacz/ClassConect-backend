package com.example.classconectbackend.utils.mappers;

import com.example.classconectbackend.team.Team;
import com.example.classconectbackend.team.TeamDto;

public class TeamMapper {

    public static TeamDto mapToDto(Team team) {

//        var teamPosts = team.getPosts().stream()
//                .map(Post::getPostId)
//                .collect(Collectors.toList());
//
//        var teamMembers = team.getMembers().stream()
//                .map(Member::getMemberId)
//                .collect(Collectors.toList());

        return new TeamDto(team.getTeamId(), team.getTeamAdmin(), team.getSubject(), team.getPassword(),
                team.getDescription(), team.getTeamName(), team.getCreationDate());
    }
}
