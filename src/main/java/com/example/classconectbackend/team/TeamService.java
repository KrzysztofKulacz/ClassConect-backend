package com.example.classconectbackend.team;

import com.example.classconectbackend.member.Member;
import com.example.classconectbackend.member.MemberRepository;
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

    public TeamDto createNewTeam(TeamCreationRequest teamCreationRequest){

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

        newTeam.addMember(member);

        var savedTeam = teamRepository.save(newTeam);

        return TeamMapper.mapToDto(savedTeam);
    }

    public TeamDto getTeam(String teamId) {

        var team = teamRepository.findById(UUID.fromString(teamId))
                .orElseThrow(() -> new IllegalStateException("Team doesn't exist"));

        //TODO zmienic tu members i posts w team na DTOs

        return TeamMapper.mapToDto(team);

    }

    public List<TeamDto> getTeams(String email){

        Member member = memberRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalStateException("member doesn't exist"));

        List<Team> teams = teamRepository.findByMemberId(member.getMemberId())
                .orElseThrow(() -> new IllegalStateException("member doesn't exist"));

        return teams.stream()
                .map(TeamMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public void deleteTeam(String teamId) {

        teamRepository.delete(teamRepository.findById(UUID.fromString(teamId))
                .orElseThrow(() -> new IllegalStateException("Team doesn't exist")));
        //TODO dodać usuwanie wszystkich postów tej grupy

    }
}
