package com.example.classconectbackend.validation.validators;

import com.example.classconectbackend.exception.IncorrectJoinRequest;
import com.example.classconectbackend.exception.IncorrectTeamPasswordException;
import com.example.classconectbackend.exception.MemberExistsInTeamException;
import com.example.classconectbackend.exception.NoSuchTeamException;
import com.example.classconectbackend.member.MemberRepository;
import com.example.classconectbackend.team.TeamJoinRequest;
import com.example.classconectbackend.team.TeamRepository;
import com.example.classconectbackend.validation.annotations.JoinTeamValidation;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import java.util.NoSuchElementException;

import static java.util.Objects.isNull;

@Service
public class JoinTeamValidator implements ConstraintValidator<JoinTeamValidation, TeamJoinRequest> {

    private final TeamRepository teamRepository;
    private final MemberRepository memberRepository;

    public JoinTeamValidator(TeamRepository teamRepository, MemberRepository memberRepository) {
        this.teamRepository = teamRepository;
        this.memberRepository = memberRepository;
    }

    public boolean isValid(TeamJoinRequest teamJoinRequest, ConstraintValidatorContext context) {

        if (isJoinRequestInvalid(teamJoinRequest)){
            throw new IncorrectJoinRequest();
        }

        if (isTeamDoesNotExists(teamJoinRequest)) {
            throw new NoSuchTeamException();
        }

        if (isPasswordIncorrect(teamJoinRequest)) {
            throw new IncorrectTeamPasswordException();
        }

        if (isMemberInRequestedTeam(teamJoinRequest)){
            throw new MemberExistsInTeamException();
        }

        return true;
    }

    private boolean isJoinRequestInvalid(TeamJoinRequest teamJoinRequest) {

        if (isNull(teamJoinRequest.getUserMail()) || isNull(teamJoinRequest.getTeamName())){
            throw new IncorrectJoinRequest();
        }

        return false;
    }

    private boolean isMemberInRequestedTeam(TeamJoinRequest teamJoinRequest) {

        var requestMember = memberRepository.findByEmail(teamJoinRequest.getUserMail())
                .orElseThrow(NoSuchElementException::new);

        return requestMember.getTeams()
                .stream()
                .anyMatch(team -> team.getTeamName().equals(teamJoinRequest.getTeamName()));

    }

    private boolean isPasswordIncorrect(TeamJoinRequest teamJoinRequest) {

        var requestedTeam = teamRepository.findByTeamName(teamJoinRequest.getTeamName())
                .orElseThrow(NoSuchTeamException::new);

        if (isNull(requestedTeam.getPassword())) {
            return false;
        }

        if (isNull(teamJoinRequest.getPassword())){
            return true;
        }

        return !requestedTeam.getPassword().equals(teamJoinRequest.getPassword());
    }

    private boolean isTeamDoesNotExists(TeamJoinRequest teamJoinRequest) {
        return !teamRepository.existsByTeamName(teamJoinRequest.getTeamName());
    }
}
