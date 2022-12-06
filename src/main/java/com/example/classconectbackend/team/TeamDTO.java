package com.example.classconectbackend.team;

import com.example.classconectbackend.member.MemberDto;
import com.example.classconectbackend.post.PostDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class TeamDTO {

    private UUID teamAdmin;
    private Subject subject;
    private String password;
    private LocalDateTime creationDate;
    private List<PostDTO> posts;
    private List<MemberDto> members;

    public TeamDTO(UUID teamAdmin, Subject subject, String password, LocalDateTime creationDate,
                   List<PostDTO> posts, List<MemberDto> members) {
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

    public List<PostDTO> getPosts() {
        return posts;
    }

    public void setPosts(List<PostDTO> posts) {
        this.posts = posts;
    }

    public List<MemberDto> getMembers() {
        return members;
    }

    public void setMembers(List<MemberDto> members) {
        this.members = members;
    }
}
