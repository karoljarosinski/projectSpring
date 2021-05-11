package com.kj.plusligaprojekt.team;

import com.kj.plusligaprojekt.player.PlayerRepository;
import com.kj.plusligaprojekt.table.Stats;
import com.kj.plusligaprojekt.table.StatsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TeamController {

    private TeamRepository teamRepository;
    private PlayerRepository playerRepository;
    private StatsRepository statsRepository;

    public TeamController(TeamRepository teamRepository, PlayerRepository playerRepository, StatsRepository statsRepository) {
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
        this.statsRepository = statsRepository;
    }

    @GetMapping("/teams")
    public String teams(Model model) {
        List<Team> teams = teamRepository.findAll();
        model.addAttribute("teams", teams);
        return "team/teams";
    }

    @GetMapping("/team/{teamName}")
    public String teamPlayers(@PathVariable String teamName, Model model) {
        Team team = teamRepository.findByTeamName(teamName);
        model.addAttribute("team", team);
        model.addAttribute("players", playerRepository.findByTeam(team));
        return "team/teamPlayers";
    }


    @GetMapping("/teams/{id}")
    public String editTeam(@PathVariable Long id, Model model) {
        Team team = teamRepository.findById(id).get();
        model.addAttribute("teamToEdit", team);
        return "team/editTeam";
    }

    @PostMapping("/teams/{id}")
    public String editTeam(@PathVariable Long id, Team team) {
        teamRepository.save(team);
        return "redirect:/teams";
    }

    @GetMapping("/addTeam")
    public String addTeam(Model model) {
        model.addAttribute("team", new Team());
        return "team/addTeam";
    }

    @PostMapping("/addTeam")
    public String addTeam(Team team) {
        statsRepository.save(new Stats());
        teamRepository.save(team);
        teamRepository.assignStatsId(team.getId());
        return "redirect:/";
    }

    @GetMapping("/teams/remove/{id}")
    public String removePlayer(@PathVariable Long id) {
        teamRepository.deleteById(id);
        return "redirect:/teams";
    }

}
