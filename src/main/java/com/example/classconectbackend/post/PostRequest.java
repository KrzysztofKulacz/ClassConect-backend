package com.example.classconectbackend.post;

import java.util.UUID;

public class PostRequest {

    private String title;
    private String text;
    private UUID member;
    private UUID team;

    public PostRequest(String title, String text, UUID member, UUID team) {
        this.title = title;
        this.text = text;
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
