package com.example.classconectbackend.post;

import com.example.classconectbackend.member.Member;
import com.example.classconectbackend.team.Team;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "post", schema = "public")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "post_id")
    private UUID postId;

    @Column(name = "title")
    private String title;

    @Column(name = "text")
    private String text;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "memberId", referencedColumnName = "member_id",
            foreignKey = @ForeignKey(name = "post_member_fk"))
    private Member member;

    @ManyToOne
    @JoinColumn(name = "teamId", referencedColumnName = "team_id",
            foreignKey = @ForeignKey(name = "post_team_fk"))
    private Team team;

    public Post() {
    }

    public Post(UUID postId, String title, String text, Member member) {
        this.postId = postId;
        this.title = title;
        this.text = text;
        this.member = member;
    }

    public UUID getPostId() {
        return postId;
    }

    public void setPostId(UUID postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(postId, post.postId) && Objects.equals(title, post.title) && Objects.equals(text, post.text) && Objects.equals(member, post.member);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, title, text);
    }
}
