package com.example.classconectbackend.post;

import com.example.classconectbackend.team.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PostRepository extends JpaRepository<Post, UUID> {

    @Query("SELECT m FROM Post m WHERE m.postId = :postId")
    Optional<Post> findById(@Param("postId") UUID postId);

}