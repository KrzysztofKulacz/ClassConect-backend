package com.example.classconectbackend.post;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.UUID;

public class PostDto {

    private UUID postId;
    @JsonProperty("postAuthorId")
    private UUID memberId;
    @JsonProperty("groupId")
    private UUID team;
    private String postAuthor;
    private String title;
    private String content;
    private LocalDateTime creationDate;

    public PostDto(UUID postId, UUID memberId, UUID team, String postAuthor,
                   String title, String content, LocalDateTime creationDate) {
        this.postId = postId;
        this.memberId = memberId;
        this.team = team;
        this.postAuthor = postAuthor;
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
    }

    public UUID getPostId() {
        return postId;
    }

    public void setPostId(UUID postId) {
        this.postId = postId;
    }

    public UUID getMemberId() {
        return memberId;
    }

    public void setMemberId(UUID memberId) {
        this.memberId = memberId;
    }

    public UUID getTeam() {
        return team;
    }

    public void setTeam(UUID team) {
        this.team = team;
    }

    public String getPostAuthor() {
        return postAuthor;
    }

    public void setPostAuthor(String postAuthor) {
        this.postAuthor = postAuthor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
}
