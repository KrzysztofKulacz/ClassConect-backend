package com.example.classconectbackend.team;

public class TeamRequest {

    private Subject subject;
    private String password;
    private String memberEmail;

    public TeamRequest() {
    }

    public TeamRequest(Subject subject, String password, String member_email) {
        this.subject = subject;
        this.password = password;
        this.memberEmail = member_email;
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

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }
}
