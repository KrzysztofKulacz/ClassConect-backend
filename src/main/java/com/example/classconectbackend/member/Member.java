package com.example.classconectbackend.member;

import com.example.classconectbackend.squad.Squad;
import com.example.classconectbackend.post.Post;
import org.hibernate.annotations.Cascade;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "member")
public class Member {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "is_account_non_expired")
    private boolean isAccountNonExpired;

    @Column(name = "is_account_non_locked")
    private boolean isAccountNonLocked;

    @Column(name = "is_credentials_non_expired")
    private boolean isCredentialsNonExpired;

    @Column(name = "is_enabled")
    private boolean isEnabled;

    @Column(name = "authorities")
    private String authorities;

    @Column
    @ManyToMany(mappedBy = "members")
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private List<Squad> squads = new ArrayList<>();

    @Column
    @OneToMany(
            mappedBy = "member",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private List<Post> posts = new ArrayList<>();

    public Member() {}

    public Member(UUID id, String username, String password, String email, boolean isAccountNonExpired, boolean isAccountNonLocked, boolean isCredentialsNonExpired, boolean isEnabled, String authorities, List<Squad> squads, List<Post> posts) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.isAccountNonExpired = isAccountNonExpired;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isCredentialsNonExpired = isCredentialsNonExpired;
        this.isEnabled = isEnabled;
        this.authorities = authorities;
        this.squads = squads;
        //this.posts = posts;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        isAccountNonExpired = accountNonExpired;
    }

    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        isAccountNonLocked = accountNonLocked;
    }

    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        isCredentialsNonExpired = credentialsNonExpired;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public List<Squad> getSquads() {
        return squads;
    }

    public void setSquads(List<Squad> squads) {
        this.squads = squads;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public void addSquad(Squad squad){
        squads.add(squad);
    }

    public void addPost(Post post) {
        if(!this.posts.contains(post)){
            this.posts.add(post);
            post.setMember(this);
        }
    }

    public void removePost(Post post) {
        if(this.posts.contains(post)){
            this.posts.remove(post);
            post.setMember(null);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return isAccountNonExpired == member.isAccountNonExpired &&
                isAccountNonLocked == member.isAccountNonLocked &&
                isCredentialsNonExpired == member.isCredentialsNonExpired &&
                isEnabled == member.isEnabled &&
                Objects.equals(id, member.id) &&
                Objects.equals(username, member.username) &&
                Objects.equals(password, member.password) &&
                Objects.equals(email, member.email) &&
                Objects.equals(authorities, member.authorities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, email, isAccountNonExpired, isAccountNonLocked,
                isCredentialsNonExpired, isEnabled, authorities, posts);
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", isAccountNonExpired=" + isAccountNonExpired +
                ", isAccountNonLocked=" + isAccountNonLocked +
                ", isCredentialsNonExpired=" + isCredentialsNonExpired +
                ", isEnabled=" + isEnabled +
                ", authorities='" + authorities + '\'' +
                ", squads='" + squads + '\''+
                ", posts='" + posts + '\''+
                '}';
    }
}
