package com.kj.plusligaprojekt.player;

import com.kj.plusligaprojekt.team.TeamRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/players")
public class PlayerController {

    private PlayerRepository playerRepository;
    private TeamRepository teamRepository;

    public PlayerController(PlayerRepository playerRepository, TeamRepository teamRepository) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
    }

    @GetMapping("/{id}")
    public String editPlayer(@PathVariable Long id, Model model) {
        Player player = playerRepository.findById(id).get();
        model.addAttribute("playerToEdit", player);
        model.addAttribute("teams", teamRepository.findAll());
        return "player/editPlayer";
    }

    @PostMapping("/{id}")
    public String editPlayer(@PathVariable Long id, Player player) {
        playerRepository.save(player);
        return "redirect:/players";
    }

    @GetMapping
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

    @GetMapping("/remove/{id}")
    public String removePlayer(@PathVariable Long id) {
        playerRepository.deleteById(id);
        return "redirect:/players";
    }
}
