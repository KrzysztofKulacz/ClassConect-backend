package com.example.classconectbackend.post;

import com.example.classconectbackend.member.Member;
import com.example.classconectbackend.squad.Squad;

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
            name = "member",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "member_post_fk"
            )
    )
    private Member member;

    @ManyToOne
    @JoinColumn(
            name = "squad",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "squad_post_fk"
            )
    )
    private Squad squad;

    public Post() {}

    public Post(Squad squad, Member member, String title, String text) {
        this.squad = squad;
        this.member = member;
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

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Squad getSquad() {
        return squad;
    }

    public void setSquad(Squad squad) {
        this.squad = squad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id) &&
                Objects.equals(title, post.title) &&
                Objects.equals(text, post.text) &&
                Objects.equals(member, post.member) &&
                Objects.equals(squad, post.squad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, text, member, squad);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", member=" + member + '\'' +
                ", squad=" + squad +
                '}';
    }

}
