package com.example.tris.model;

public class Game {
    private char[][] board = new char[3][3];
    private char currentPlayer = 'X';
    private boolean gameOver = false;
    private String winner = "";

    public Game() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = ' ';
    }

    public boolean play(int row, int col) {
        if (gameOver || board[row][col] != ' ') return false;

        board[row][col] = currentPlayer;

        if (checkWin(currentPlayer)) {
            gameOver = true;
            winner = String.valueOf(currentPlayer);
        } else if (isBoardFull()) {
            gameOver = true;
            winner = "Draw";
        } else {
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        return true;
    }

    private boolean isBoardFull() {
        for (char[] row : board)
            for (char cell : row)
                if (cell == ' ') return false;
        return true;
    }

    private boolean checkWin(char player) {
        for (int i = 0; i < 3; i++)
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                (board[0][i] == player && board[1][i] == player && board[2][i] == player))
                return true;

        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
               (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    public char[][] getBoard() { return board; }
    public char getCurrentPlayer() { return currentPlayer; }
    public boolean isGameOver() { return gameOver; }
    public String getWinner() { return winner; }
}
