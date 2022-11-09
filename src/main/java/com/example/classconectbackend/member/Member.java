package com.example.classconectbackend.member;

import com.example.classconectbackend.post.Post;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "member",schema = "public")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_id")
    private UUID memberId;

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

    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Post> posts = new ArrayList<>();

    public Member() {
    }

    public void addPost(Post post){
        post.setMember(this);
        this.posts.add(post);
    }

    public UUID getMemberId() {
        return memberId;
    }

    public void setMemberId(UUID memberId) {
        this.memberId = memberId;
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

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return isAccountNonExpired == member.isAccountNonExpired && isAccountNonLocked == member.isAccountNonLocked && isCredentialsNonExpired == member.isCredentialsNonExpired && isEnabled == member.isEnabled && Objects.equals(memberId, member.memberId) && Objects.equals(username, member.username) && Objects.equals(password, member.password) && Objects.equals(email, member.email) && Objects.equals(authorities, member.authorities) && Objects.equals(posts, member.posts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, username, password, email, isAccountNonExpired, isAccountNonLocked, isCredentialsNonExpired, isEnabled, authorities, posts);
    }


}
