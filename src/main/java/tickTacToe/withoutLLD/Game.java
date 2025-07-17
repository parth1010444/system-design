package tickTacToe.withoutLLD;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private Board board;
    private ArrayList<Player> players;
    private char[][] matrix;

    private int winner;

    public int getWinner() {
        return winner;
    }

    public Game(int sizeOfBoard, int numberOfPlayers) {
        board = new Board(sizeOfBoard,numberOfPlayers);
        players = new ArrayList<>(numberOfPlayers + 1);
        for (int i = 0;i < numberOfPlayers; i++) {
            players.add(board.associatePlayerToPiece((char)(65 + i)));
        }
        matrix = board.getMatrix();
        initializeMatrix();
    }

    public void printMatrix() {
        for(int row = 0; row < board.getSize(); row++) {
            for(int colm = 0; colm < board.getSize(); colm++) {
                System.out.print(matrix[row][colm] + " | ");
            }
            System.out.println();
        }
    }

    public void initializeMatrix() {
        for(int row = 0; row < board.getSize(); row++) {
            for(int colm = 0; colm < board.getSize(); colm++) {
                matrix[row][colm] = '.';
            }
        }
    }

    public boolean isGameEnded() {
        // check in row
        for(int row = 0; row < board.getSize(); row++) {
            boolean flag = true;
            for(int colm = 1; colm < board.getSize(); colm++) {

                if( (matrix[row][colm] == '.') || matrix[row][colm] != matrix[row][colm-1] ) {
                    flag = false;
                    break;
                }
            }
            if(flag) return true;
        }

        // check in colm
        for(int colm = 0; colm < board.getSize(); colm++) {
            boolean flag = true;
            for(int row = 1; row < board.getSize(); row++) {
                if( (matrix[row][colm] == '.') ||  matrix[row][colm] != matrix[row-1][colm] ) {
                    flag = false;
                    break;
                }
            }
            if(flag) return true;
        }

        // check in left diagonal
        boolean flag = true;
        for(int i = 1;i < board.getSize(); i++) {
            if((matrix[i][i] == '.') ||  matrix[i][i] != matrix[i-1][i-1]) {
                flag = false;
            }
        }
        if(flag) return true;

        // check in right diagonal
        flag = true;
        for(int i = 0,j = board.getSize() - 1; i < board.getSize() - 1; i++,j--) {
            if((matrix[i][j] == '.') || matrix[i][j] != matrix[i+1][j-1]) {
                flag = false;
            }
        }

        return flag;
    }

    public void startGame() {

        int playerWithTurn = 1;
        int numberOfTurns = 0;
        Scanner sc = new Scanner(System.in);
        while( numberOfTurns < board.getSize() * board.getSize() ) {
            printMatrix();
            System.out.println("Enter move for Player " + playerWithTurn);
            int row, colm;
            row = sc.nextInt();
            colm = sc.nextInt();
            if( matrix[row][colm] == players.get(0).getPiece().getGameCharacter()
                    || matrix[row][colm] == players.get(1).getPiece().getGameCharacter()) {
                System.out.println("Please enter valid move ");
                continue;
            }
            matrix[row][colm] = players.get(playerWithTurn - 1).getPiece().getGameCharacter();
            if ( isGameEnded() ) {
                winner = playerWithTurn;
                break;
            }
            numberOfTurns++;
            if( numberOfTurns % 2 == 0) {
                playerWithTurn = 1;
            }
            else {
                playerWithTurn = 2;
            }
        }
        if( numberOfTurns == (board.getSize() * board.getSize()) ) {
            winner = 0;
        }
    }

}
