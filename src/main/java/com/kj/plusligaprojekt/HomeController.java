package com.kj.plusligaprojekt;

import com.kj.plusligaprojekt.news.News;
import com.kj.plusligaprojekt.news.NewsRepository;
import com.kj.plusligaprojekt.team.TeamRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {
    private final NewsRepository newsRepository;
    private final TeamRepository teamRepository;


    public HomeController(NewsRepository newsRepository, TeamRepository teamRepository) {
        this.newsRepository = newsRepository;
        this.teamRepository = teamRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<News> news = newsRepository.findAll();
        model.addAttribute("news", news);
        return "home/home";
    }

    @GetMapping("/article/{id}")
    public String home(@PathVariable Long id, Model model) {
        Optional<News> articles = newsRepository.findById(id);
        if (articles.isPresent()) {
            News article = articles.get();
            model.addAttribute("article", article);
        } else {
            return "redirect:/";
        }
        return "home/article";
    }


}
