package com.example.classconectbackend.team;

import com.example.classconectbackend.member.Member;
import com.example.classconectbackend.post.Post;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "team")
public class Team {

    @Id
    @Column(name = "team_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID teamId;

    @Column(name = "group_admin")
    private UUID groupAdmin;

    @Column(name = "subject")
    @Enumerated(EnumType.STRING)
    private Subject subject;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Post> posts = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "member_team",
            joinColumns = @JoinColumn(name = "teamId", referencedColumnName = "team_id"),
            inverseJoinColumns = @JoinColumn(name = "memberId",referencedColumnName = "member_id")
    )
    private List<Member> members = new ArrayList<>();

    public Team() {
    }

    public Team(UUID teamId, Subject subject, String password, List<Post> posts) {
        this.teamId = teamId;
        this.subject = subject;
        this.password = password;
        this.posts = posts;
    }

    public UUID getTeamId() {
        return teamId;
    }

    public void setTeamId(UUID teamId) {
        this.teamId = teamId;
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

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public void addMember(Member member){
        this.members.add(member);
        member.getTeams().add(this);
    }

    public void removeMember(Member member){
        this.members.remove(member);
        member.getTeams().remove(this);
    }

    public void addPost(Post post) {
        post.setTeam(this);
        this.posts.add(post);
    }

    public UUID getGroupAdmin() {
        return groupAdmin;
    }

    public void setGroupAdmin(UUID groupAdmin) {
        this.groupAdmin = groupAdmin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(teamId, team.teamId) && subject == team.subject && Objects.equals(password, team.password) && Objects.equals(posts, team.posts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamId, subject, password, posts);
    }
}
