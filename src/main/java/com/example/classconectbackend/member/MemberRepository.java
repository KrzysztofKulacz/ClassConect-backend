package com.example.classconectbackend.member;

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

    @Query("SELECT m FROM Member m WHERE m.memberId = :id")
    Optional<Member> findById(@Param("id") UUID id);

    @Query("""
            SELECT COUNT (m) > 0 FROM Member m
            JOIN  m.teams t
            WHERE m.memberId = :userId
            AND t.teamId = :groupId
            """)
    boolean isUserWithinGroup(@Param("userId") UUID userId, @Param("groupId") UUID groupId);
}
