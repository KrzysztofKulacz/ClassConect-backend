package com.example.classconectbackend.team;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TeamCreationRequest {

    private Subject subject;
    private String description;
    private String password;
    @JsonProperty("groupName")
    private String teamName;
    private String memberEmail;

    public TeamCreationRequest() {
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
