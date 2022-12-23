package com.example.classconectbackend.team;

import com.example.classconectbackend.validation.annotations.JoinTeamValidation;
import com.fasterxml.jackson.annotation.JsonProperty;

@JoinTeamValidation
public class TeamJoinRequest {

    private String userMail;

    @JsonProperty("groupName")
    private String teamName;

    private String password;

    public TeamJoinRequest() {
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }
}
