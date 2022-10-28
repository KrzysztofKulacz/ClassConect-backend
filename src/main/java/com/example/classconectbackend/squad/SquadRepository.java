package com.example.classconectbackend.squad;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SquadRepository extends JpaRepository<Squad, UUID> {
}
