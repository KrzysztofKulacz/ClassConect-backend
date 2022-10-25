package com.example.classconectbackend.domain;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "post")
public class Post {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private String title;

    @Column
    private String text;

    @ManyToOne
    @JoinColumn(
            name = "user1",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "user_post_fk"
            )
    )
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private User user1;

    @ManyToOne
    @JoinColumn(
            name = "group1",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "group_post_fk"
            )
    )
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Group group1;

    public Post() {}

    public Post(Group group1, User user1, String title, String text) {
        this.group1 = group1;
        this.user1 = user1;
        this.title = title;
        this.text = text;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public Group getGroup1() {
        return group1;
    }

    public void setGroup1(Group group1) {
        this.group1 = group1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id) &&
                Objects.equals(title, post.title) &&
                Objects.equals(text, post.text) &&
                Objects.equals(user1, post.user1) &&
                Objects.equals(group1, post.group1);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, text, user1, group1);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", user1=" + user1 + '\'' +
                ", group1=" + group1 +
                '}';
    }

}
