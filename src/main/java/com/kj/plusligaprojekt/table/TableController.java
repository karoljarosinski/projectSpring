package com.kj.plusligaprojekt.table;

import com.kj.plusligaprojekt.team.TeamRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/table")
public class TableController {

    private TeamRepository teamRepository;

    public TableController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @GetMapping
    public String table(Model model) {
        model.addAttribute("teams", teamRepository.findAll());
        return "table/table";
    }

    @PostMapping
    public String table(Stats stats, Model model) {
        model.addAttribute("teams", teamRepository.findAll());
        return "table/table";
    }
}
