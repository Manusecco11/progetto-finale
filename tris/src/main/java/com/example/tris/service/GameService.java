package com.example.tris.service;

import com.example.tris.model.Game;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    private Game game = new Game();

    public Game getGame() {
        return game;
    }

    public void play(int row, int col) {
        game.play(row, col);
    }

    public void reset() {
        game = new Game();
    }
}
