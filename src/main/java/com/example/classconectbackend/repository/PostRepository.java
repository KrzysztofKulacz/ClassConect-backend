package com.example.classconectbackend.repository;

import com.example.classconectbackend.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID> {
}
