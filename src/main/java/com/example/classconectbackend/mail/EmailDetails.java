package com.example.classconectbackend.mail;

public class EmailDetails {

    private String sender;
    private String recipient;
    private String msgBody;
    private String subject;

    public EmailDetails() {
    }

    public EmailDetails(String sender, String recipient, String msgBody, String subject) {
        this.sender = sender;
        this.recipient = recipient;
        this.msgBody = msgBody;
        this.subject = subject;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getMsgBody() {
        return msgBody;
    }

    public void setMsgBody(String msgBody) {
        this.msgBody = msgBody;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
