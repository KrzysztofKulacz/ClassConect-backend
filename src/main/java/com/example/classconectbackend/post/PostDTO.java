package com.example.classconectbackend.post;

import com.example.classconectbackend.member.MemberDto;
import com.example.classconectbackend.team.TeamDTO;

import java.time.LocalDateTime;

public class PostDTO {

    private String title;
    private String text;
    private LocalDateTime creationDate;
    private MemberDto member;
    private TeamDTO team;

    public PostDTO(String title, String text, LocalDateTime creationDate,
                   MemberDto member, TeamDTO team) {
        this.title = title;
        this.text = text;
        this.creationDate = creationDate;
        this.member = member;
        this.team = team;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public MemberDto getMember() {
        return member;
    }

    public void setMember(MemberDto member) {
        this.member = member;
    }

    public TeamDTO getTeam() {
        return team;
    }

    public void setTeam(TeamDTO team) {
        this.team = team;
    }
}
