package com.example.classconectbackend.utils.mappers;

import com.example.classconectbackend.member.Member;
import com.example.classconectbackend.post.Post;
import com.example.classconectbackend.team.Team;
import com.example.classconectbackend.team.TeamDto;
import java.util.stream.Collectors;

public class TeamMapper {

    public static TeamDto mapToDto(Team team){

        var teamPosts = team.getPosts().stream()
                .map(Post::getPostId)
                .collect(Collectors.toList());

        var teamMembers = team.getMembers().stream()
                .map(Member::getMemberId)
                .collect(Collectors.toList());

        return new TeamDto(team.getTeamAdmin(), team.getSubject(), team.getPassword(),
                team.getCreationDate(), teamPosts, teamMembers);
    }
}
