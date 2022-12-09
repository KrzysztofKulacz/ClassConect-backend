package com.example.classconectbackend.team;

import com.example.classconectbackend.member.Member;
import com.example.classconectbackend.post.Post;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class TeamDto {

    private UUID teamAdmin;
    private Subject subject;
    private String password;
    private LocalDateTime creationDate;
    private List<UUID> posts;
    private List<UUID> members;

    public TeamDto(UUID teamAdmin, Subject subject, String password, LocalDateTime creationDate,
                   List<UUID> posts, List<UUID> members) {
        this.teamAdmin = teamAdmin;
        this.subject = subject;
        this.password = password;
        this.creationDate = creationDate;
        this.posts = posts;
        this.members = members;
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

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public List<UUID> getPosts() {
        return posts;
    }

    public void setPosts(List<UUID> posts) {
        this.posts = posts;
    }

    public List<UUID> getMembers() {
        return members;
    }

    public void setMembers(List<UUID> members) {
        this.members = members;
    }
}
