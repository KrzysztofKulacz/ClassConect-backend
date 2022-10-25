package com.example.classconectbackend.domain;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "group1")
public class Group {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID groupAdmin;

    @Column
    private String subject;

    @Column
    private String password;

    @Column(name = "users")
    @ManyToMany(mappedBy = "groups")
    private List<User> users = new ArrayList<>();

    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "posts")
    @OneToMany(
            mappedBy = "group1",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<Post> posts = new ArrayList<>();

    public Group() {}

    @Autowired
    public Group(String subject, String password) {
        this.subject = subject;
        this.password = password;
    }

    public UUID getGroupAdmin() {
        return groupAdmin;
    }

    public void setGroupAdmin(UUID groupAdmin) {
        this.groupAdmin = groupAdmin;
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public void addUser(User user){
        users.add(user);
    }

    public void addPost(Post post) {
        if(!this.posts.contains(post)){
            this.posts.add(post);
            post.setGroup1(this);
        }
    }

    public void removePost(Post post) {
        if(this.posts.contains(post)){
            this.posts.remove(post);
            post.setGroup1(null);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(groupAdmin, group.groupAdmin) &&
                Objects.equals(subject, group.subject) &&
                Objects.equals(password, group.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupAdmin, subject, password, posts);
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupAdmin=" + groupAdmin +
                ", subject='" + subject + '\'' +
                ", password='" + password + '\'' +
                ", users='" + users + '\'' +
                ", posts='" + posts + '\'' +
                '}';
    }
}
