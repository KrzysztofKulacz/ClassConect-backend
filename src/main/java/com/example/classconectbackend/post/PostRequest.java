package com.example.classconectbackend.post;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class PostRequest {

    private String title;
    private String content;
    @JsonProperty("userId")
    private UUID member;
    @JsonProperty("groupId")
    private UUID team;

    public PostRequest(String title, String content, UUID member, UUID team) {
        this.title = title;
        this.content = content;
        this.member = member;
        this.team = team;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
