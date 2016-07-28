package chesscalculator;

import chesscalculator.piece.Piece;

/**
 * @author Mikael KROK
 * @date 23/06/2016
 */
public class Movement {

    private Piece p;

    private Position destination;

    private boolean eat = false;

    public Movement(Piece p, Position destination, boolean eat) {
        this.p = p;
        this.destination = destination;
        this.eat = eat;
    }

    public Piece getP() {
        return p;
    }
    public Position getDestination() {
        return destination;
    }

    public boolean isEat() {
        return eat;
    }
}
