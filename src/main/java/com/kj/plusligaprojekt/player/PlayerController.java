package com.kj.plusligaprojekt.player;

import com.kj.plusligaprojekt.team.TeamRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PlayerController {

    private PlayerRepository playerRepository;
    private TeamRepository teamRepository;

    public PlayerController(PlayerRepository playerRepository, TeamRepository teamRepository) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
    }

    @GetMapping("/players/{id}")
    public String editPlayer(@PathVariable Long id, Model model) {
        Player player = playerRepository.findById(id).get();
        model.addAttribute("playerToEdit", player);
        return "player/editPlayer";
    }

    @PostMapping("/players/{id}")
    public String editPlayer(@PathVariable Long id, Player player) {
        playerRepository.save(player);
        return "redirect:/players";
    }

    @GetMapping("/players")
    public String players(Model model) {
        List<Player> players = playerRepository.findAll();
        model.addAttribute("players", players);
        return "player/players";
    }

    @GetMapping("/addPlayer")
    public String addPlayer(Model model) {
        model.addAttribute("player", new Player());
        model.addAttribute("teams", teamRepository.findAll());
        return "player/addPlayer";
    }

    @PostMapping("/addPlayer")
    public String addPlayer(Player player) {
        playerRepository.save(player);
        return "redirect:/";
    }
}
