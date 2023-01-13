package com.example.classconectbackend.post;

import java.time.LocalDateTime;
import java.util.UUID;

public class PostDto {

    private String title;
    private String text;
    private LocalDateTime creationDate;
    private UUID member;
    private UUID team;

    public PostDto(String title, String text, LocalDateTime creationDate,
                   UUID member, UUID team) {
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

    public UUID getMember() {
        return member;
    }

    public void setMember(UUID member) {
        this.member = member;
    }

    public UUID getTeam() {
        return team;
    }

    public void setTeam(UUID team) {
        this.team = team;
    }
}
