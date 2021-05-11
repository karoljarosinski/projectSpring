package com.kj.plusligaprojekt.team;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface TeamRepository extends JpaRepository<Team, Long> {

    Team findByTeamName(String teamName);

    @Transactional
    @Modifying
    @Query("update Team t set t.stats.id = t.id where t.id = :id")
    void assignStatsId(@Param(value = "id") Long id);
}
