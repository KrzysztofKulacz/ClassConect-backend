package com.example.classconectbackend.team;

import com.example.classconectbackend.member.MemberRepository;
import com.example.classconectbackend.utils.ImageLoader;
import com.example.classconectbackend.utils.mappers.TeamMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TeamService {

    private final TeamRepository teamRepository;
    private final MemberRepository memberRepository;

    public TeamService(TeamRepository teamRepository, MemberRepository memberRepository) {
        this.teamRepository = teamRepository;
        this.memberRepository = memberRepository;
    }

    public TeamDto createNewTeam(TeamCreationRequest teamCreationRequest) {

        var newTeam = new Team();
        var creationDate = LocalDateTime.now();
        var member = memberRepository.findByEmail(teamCreationRequest.getMemberEmail())
                .orElseThrow(() -> new IllegalStateException("member doesn't exist"));

        newTeam.setTeamAdmin(member.getMemberId());
        newTeam.setSubject(teamCreationRequest.getSubject());
        newTeam.setCreationDate(creationDate);
        newTeam.setTeamName(teamCreationRequest.getTeamName());
        newTeam.setDescription(teamCreationRequest.getDescription());
        newTeam.setPassword(teamCreationRequest.getPassword());
        newTeam.setImageUrl(ImageLoader.loadSubject(teamCreationRequest.getSubject()));
        newTeam.addMember(member);

        var savedTeam = teamRepository.save(newTeam);

        return TeamMapper.mapToDto(savedTeam);
    }



    public TeamDto joinToTeam(TeamJoinRequest teamJoinRequest) {

        var memberJoin = memberRepository.findByEmail(teamJoinRequest.getUserMail()).get();
        var teamJoin = teamRepository.findByTeamName(teamJoinRequest.getTeamName()).get();

        memberJoin.addTeam(teamJoin);
        memberRepository.save(memberJoin);

        return TeamMapper.mapToDto(teamJoin);
    }

    public TeamDto getTeam(String teamId) {

        var team = teamRepository.findById(UUID.fromString(teamId))
                .orElseThrow(() -> new IllegalStateException("Team doesn't exist"));

        return TeamMapper.mapToDto(team);

    }

    public List<TeamDto> getMemberTeams(String email) {

        var member = memberRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalStateException("member doesn't exist"));

        return member.getTeams()
                .stream()
                .map(TeamMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public void deleteTeam(String teamId) {
        teamRepository.deleteById(UUID.fromString(teamId));
    }

    public List<TeamDto> getAvailableTeams() {
        return teamRepository.findAll()
                .stream()
                .map(TeamMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
