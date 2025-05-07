package com.example.tris.controller;

import com.example.tris.service.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TrisController {

    private final GameService gameService;

    public TrisController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("game", gameService.getGame());
        return "index";
    }

    @PostMapping("/play")
    public String play(@RequestParam int row, @RequestParam int col) {
        gameService.play(row, col);
        return "redirect:/";
    }

    @PostMapping("/reset")
    public String reset() {
        gameService.reset();
        return "redirect:/";
    }
}
