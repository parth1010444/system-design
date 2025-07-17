package tickTacToe.withoutLLD;

public class Board {

    private int size;
    private int numberOfPlayers;

    private char[][] matrix;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public char[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(char[][] matrix) {
        this.matrix = matrix;
    }

    public Board(int size, int numberOfPlayers) {
        this.size = size;
        this.numberOfPlayers = numberOfPlayers;
        matrix = new char[size][size];
    }
    public Player associatePlayerToPiece(char pieceType) {
        return new Player(new Piece(pieceType));
    }
}
