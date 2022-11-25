package com.example.classconectbackend.member;

import java.time.LocalDateTime;
import java.util.List;

public class MemberDto {

    private String username;
    private String email;
    private Role role;
    private List<String> authorities;
    private LocalDateTime creationDate;

    public MemberDto(String username, String email, Role role, List<String> authorities, LocalDateTime creationDate) {
        this.username = username;
        this.email = email;
        this.role = role;
        this.authorities = authorities;
        this.creationDate = creationDate;
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

