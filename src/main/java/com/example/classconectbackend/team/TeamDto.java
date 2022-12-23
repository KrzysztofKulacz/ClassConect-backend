package com.example.classconectbackend.team;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.UUID;

public class TeamDto {

    @JsonProperty("groupId")
    private UUID teamId;
    @JsonProperty("groupAdmin")
    private UUID teamAdmin;
    private Subject subject;
    private String password;
    private String description;
    @JsonProperty("title")
    private String teamName;
    private LocalDateTime creationDate;


    public TeamDto(UUID teamId, UUID teamAdmin, Subject subject, String password,
                   String description, String teamName, LocalDateTime creationDate) {
        this.teamId = teamId;
        this.teamAdmin = teamAdmin;
        this.subject = subject;
        this.password = password;
        this.description = description;
        this.teamName = teamName;
        this.creationDate = creationDate;
    }

    public UUID getTeamId() {
        return teamId;
    }

    public void setTeamId(UUID teamId) {
        this.teamId = teamId;
    }

    public UUID getTeamAdmin() {
        return teamAdmin;
    }

    public void setTeamAdmin(UUID teamAdmin) {
        this.teamAdmin = teamAdmin;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
}
