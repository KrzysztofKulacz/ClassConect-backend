package com.example.classconectbackend.team;

public class TeamRequest {

    private Subject subject;
    private String password;
    private String member_email;

    public TeamRequest(Subject subject, String password, String member_email) {
        this.subject = subject;
        this.password = password;
        this.member_email = member_email;
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

    public String getMember_email() {
        return member_email;
    }

    public void setMember_email(String member_email) {
        this.member_email = member_email;
    }
}
