package org.example;

import tickTacToe.withoutLLD.Game;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(3,2);
        game.startGame();
        int winnerNumber = game.getWinner();
        if (winnerNumber == 0) {
            System.out.println("Game tied");
        } else {
            System.out.println("Winner is " + winnerNumber);
        }
        game.printMatrix();
    }
}