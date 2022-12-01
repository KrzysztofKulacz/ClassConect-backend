package com.example.classconectbackend.team;

public class TeamRequest {

    private Subject subject;
    private String password;

    public TeamRequest(Subject subject, String password) {
        this.subject = subject;
        this.password = password;
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
}
