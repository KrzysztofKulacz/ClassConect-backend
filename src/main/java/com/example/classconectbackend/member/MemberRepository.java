package com.example.classconectbackend.member;

import com.example.classconectbackend.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface MemberRepository extends JpaRepository<Member, UUID> {

    @Query("SELECT m FROM Member m WHERE m.activationCode = :code")
    Optional<Member> findByActivationCode(@Param("code") UUID activationCode);

    @Query("SELECT m FROM Member m WHERE m.email = :email")
    Optional<Member> findByEmail(@Param("email") String email);

}
