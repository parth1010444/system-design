package tickTacToe.withoutLLD;

public class Player {

    private Piece piece;

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Player(Piece piece) {
        this.piece = piece;
    }
}
