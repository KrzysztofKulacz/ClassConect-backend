package com.example.classconectbackend.squad;

import com.example.classconectbackend.member.Member;
import com.example.classconectbackend.post.Post;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "squad")
public class Squad {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID squadAdmin;

    @Column
    private String subject;

    @Column
    private String password;

    @Column(name = "members")
    @ManyToMany(mappedBy = "squads")
    private List<Member> members = new ArrayList<>();

    @Column(name = "posts")
    @OneToMany(
            mappedBy = "squad",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<Post> posts = new ArrayList<>();

    public Squad() {}

    @Autowired
    public Squad(String subject, String password) {
        this.subject = subject;
        this.password = password;
    }

    public UUID getSquadAdmin() {
        return squadAdmin;
    }

    public void setSquadAdmin(UUID squadAdmin) {
        this.squadAdmin = squadAdmin;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public void addMember(Member member){
        members.add(member);
    }

    public void addPost(Post post) {
        if(!this.posts.contains(post)){
            this.posts.add(post);
            post.setSquad(this);
        }
    }

    public void removePost(Post post) {
        if(this.posts.contains(post)){
            this.posts.remove(post);
            post.setSquad(null);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Squad squad = (Squad) o;
        return Objects.equals(squadAdmin, squad.squadAdmin) &&
                Objects.equals(subject, squad.subject) &&
                Objects.equals(password, squad.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(squadAdmin, subject, password, posts);
    }

    @Override
    public String toString() {
        return "Squad{" +
                "squadAdmin=" + squadAdmin +
                ", subject='" + subject + '\'' +
                ", password='" + password + '\'' +
                ", members='" + members + '\'' +
                ", posts='" + posts + '\'' +
                '}';
    }
}
