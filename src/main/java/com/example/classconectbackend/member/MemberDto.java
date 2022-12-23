package com.example.classconectbackend.member;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class MemberDto {

    @JsonProperty("userId")
    private UUID memberId;
    private String username;
    private String email;
    private Role role;
    private List<String> authorities;
    private LocalDateTime creationDate;

    public MemberDto() {
    }

    public MemberDto(UUID memberId, String username, String email, Role role,
                     List<String> authorities, LocalDateTime creationDate) {
        this.memberId = memberId;
        this.username = username;
        this.email = email;
        this.role = role;
        this.authorities = authorities;
        this.creationDate = creationDate;
    }

    public UUID getMemberId() {
        return memberId;
    }

    public void setMemberId(UUID memberId) {
        this.memberId = memberId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<String> authorities) {
        this.authorities = authorities;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
}

