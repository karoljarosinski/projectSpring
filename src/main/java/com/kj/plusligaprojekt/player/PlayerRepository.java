package com.kj.plusligaprojekt.player;

import com.kj.plusligaprojekt.team.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    List<Player> findByTeam(Team team);
}
