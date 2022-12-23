package com.example.classconectbackend.team;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TeamRepository extends JpaRepository<Team, UUID> {

    @Query("SELECT m FROM Team m WHERE m.teamId = :teamId")
    Optional<Team> findById(@Param("teamId") UUID teamId);

    @Query("SELECT m FROM Team m WHERE m.teamAdmin = :admin")
    Optional<List<Team>> findByMemberId(@Param("admin") UUID admin);

    boolean existsByTeamName(String teamName);

    Optional<Team> findByTeamName(String teamName);
}
