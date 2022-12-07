package com.example.classconectbackend.post;

import com.example.classconectbackend.member.Member;
import com.example.classconectbackend.team.Team;

import java.time.LocalDateTime;

public class PostDto {

    private String title;
    private String text;
    private LocalDateTime creationDate;
    private Member member;
    private Team team;

    public PostDto(String title, String text, LocalDateTime creationDate,
                   Member member, Team team) {
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

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
